package com.bill.cols;

import com.customerInfo.coll.customerDAO;
import com.info.model.BillingDetails;
import com.info.model.customerInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insertReadingController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String CaseSelection = request.getParameter("case");
            int CaseSelction = 0;
            RequestDispatcher rd;
            try {
                CaseSelction = Integer.parseInt(CaseSelection);
            } catch (Exception e) {
                response.sendRedirect("insertReading.jsp");
            }

            if (CaseSelction == 1) {
                Boolean sucess = false;
                String Entered_CustomerId = request.getParameter("CustomerId");
                int Entered_CustomerId1 = 0;
                try {
                    Entered_CustomerId1 = Integer.parseInt(Entered_CustomerId);
                } catch (Exception e) {
                    Entered_CustomerId1 = 0;
                }
                customerDAO c = new customerDAO();
                customerInfo individualDetails = c.getIndividualDetails(Entered_CustomerId1);
                if (individualDetails != null) {
                    sucess = !sucess;
                    request.setAttribute("CustomerInfo", individualDetails);
                    BiilingDAO BilDAO = new BiilingDAO();
                    BillingDetails lastReading_Row = new BillingDetails();
                    lastReading_Row = BilDAO.lastReading_Row(Entered_CustomerId1);
                    if (lastReading_Row == null) {
                        lastReading_Row = new BillingDetails();
                        lastReading_Row.setReading_Value(0);
                        lastReading_Row.setCustomerID(Entered_CustomerId1);
                        BilDAO.NextMonth_NameGenerator("");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-yyyy");
//                        java.util.Date date = new java.util.Date();
                        String frmtdDate = dateFormat.format(individualDetails.getRegisteredDate());
                        lastReading_Row.setBill_Name(frmtdDate);
                    }
                    lastReading_Row.setBill_Name(BilDAO.NextMonth_NameGenerator(lastReading_Row.getBill_Name()));
                    request.setAttribute("lastReading_Row", lastReading_Row);
                }
                request.setAttribute("isFound", sucess);
                rd = request.getRequestDispatcher("insertReading.jsp");
                rd.forward(request, response);
            } else if (CaseSelction == 2) {// if 
                String Bill_Name = request.getParameter("Bill_Name");
                String CustomerId = request.getParameter("CustomerId");
                String Present_Units = request.getParameter("Units");
                String Last_Unit = request.getParameter("Last_Unit");
                String Bill_by_id = request.getParameter("Bill_by_id");
                String status = request.getParameter("status");

                Boolean sucess = false;
                int CustomerId1 = 0;
                int Present_Units1 = 0;
                try {
                    CustomerId1 = Integer.parseInt(CustomerId);
                } catch (Exception e) {
                    CustomerId1 = 0;
                }
                try {
                    Present_Units = Present_Units.replaceAll("[^0-9.]", "");
                    if (Present_Units.contains(".")) {
                        int temp = Present_Units.indexOf(".");
                        Present_Units = Present_Units.substring(0, temp);
                    }
                    Present_Units1 = Integer.parseInt(Present_Units);
                } catch (Exception e) {
                    Present_Units1 = 0;
                }

                int Last_Unit1 = 0;
                try {
                    Last_Unit1 = Integer.parseInt(Last_Unit);
                } catch (Exception e) {
                    Last_Unit1 = 0;
                }
                
                int Bill_by_id1 = 0;
                try {
                    Bill_by_id1 = Integer.parseInt(Bill_by_id);
                } catch (Exception e) {
                    Bill_by_id1 = 0;
                }
                int status1 = 0;
                try {
                    status1 = Integer.parseInt(status);
                } catch (Exception e) {
                    status1 = 0;
                }

                if ((Present_Units1 > Last_Unit1) && (Bill_by_id1 != 0)) {
                    BiilingDAO BilDAO = new BiilingDAO();
                    BillingDetails BillingDetail = new BillingDetails();
                    BillingDetail.setCustomerID(CustomerId1);
                    BillingDetail.setBill_Name(Bill_Name);
                    BillingDetail.setUnits(Present_Units1 - Last_Unit1);
                    BillingDetail.setReading_Value(Present_Units1);
                    BillingDetail.setReading_Bill(BilDAO.UnitTO_ReadingAmtCalculator(BillingDetail.getUnits()));
                    BillingDetail.setIsEditable(true);
                    BillingDetail.setBill_By(Bill_by_id1);
                    BillingDetail.setStatus(status1);
                    
                    Boolean InsertReading = BilDAO.InsertNewBill(BillingDetail);
                    request.setAttribute("Message", "!!! Failed !!!");
                    if (InsertReading) {
                        sucess = !sucess;
                        request.setAttribute("Message", "!!! Successfully Updated !!!");
                    }
                    request.setAttribute("isFound", sucess);
                } else {
                    if (Bill_by_id1 == 0) {
                        request.setAttribute("Message", "!!! Staff Id Not Found !!!");
                    }
                    request.setAttribute("Message", "!!! Present Reading should be Greater !!!");
                }
                request.setAttribute("isFound", sucess);
                rd = request.getRequestDispatcher("insertReading.jsp");
                rd.forward(request, response);

            }
        } catch (Exception e) {
            response.sendRedirect("insertReading.jsp");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

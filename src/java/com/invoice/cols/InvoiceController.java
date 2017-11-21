package com.invoice.cols;

import com.customerInfo.coll.customerDAO;
import com.info.model.BillingDetails;
import com.info.model.InvoiceDetails;
import com.info.model.customerInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InvoiceController extends HttpServlet {

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
                System.out.println("Integer.parseInt");
                response.sendRedirect("Invoice.jsp");
            }
            try {
                if (CaseSelction == 1) {
                    Boolean sucess = false;
                    String Entered_CustomerId = request.getParameter("CustomerId");
                    int Entered_CustomerId1 = 0;
                    try {
                        Entered_CustomerId1 = Integer.parseInt(Entered_CustomerId);
                    } catch (Exception e) {
                        Entered_CustomerId1 = 0;
                    }
                    //search in DB to valid Customer
                    customerDAO c = new customerDAO();
                    customerInfo individualDetails = c.getIndividualDetails(Entered_CustomerId1);
                    if (individualDetails != null) {
                        sucess = !sucess;
                        request.setAttribute("CustomerInfo", individualDetails);
                        InvoiceDAO Invoice = new InvoiceDAO();
                        ArrayList<BillingDetails> Get_AllRemaining_Bills = Invoice.SelectBills_NotUsed(Entered_CustomerId1);
                        request.setAttribute("AllRemaining_Bills", Get_AllRemaining_Bills);
                    }
                    request.setAttribute("isFound", sucess);
                    rd = request.getRequestDispatcher("Invoice.jsp");
                    rd.forward(request, response);
                } else if (CaseSelction == 2) {
                    Boolean IsError = false;
                    
                    Boolean isSucess = false;
                    String Recieved_Amt = request.getParameter("Recieved_Amt");
                    Double Recieved_Amt1 = 0.;
                    try {
                        Recieved_Amt1 = Double.parseDouble(Recieved_Amt);
                    } catch (Exception e) {
                        Recieved_Amt1=0.0;
                          IsError = true;
                    }
                    String Users = request.getParameter("User");
                    String Bill_of_i = request.getParameter("Bill_of_id");
                    int Bill_of_id = 0;
                    try {
                        Bill_of_id = Integer.parseInt(Bill_of_i);
                    } catch (Exception e) {
                        Bill_of_id=0;
                         IsError = true;
                    }
                    int User = 0;
                    try {
                        User = Integer.parseInt(Users);
                    } catch (Exception e) {
                        User=0;
                           IsError = true;
                    }
                    if(!IsError){
                        InvoiceDetails InvoiceDetail = new InvoiceDetails();
                        InvoiceDetail.setId(Bill_of_id);
                        InvoiceDetail.setBalance(0.0);
                        InvoiceDetail.setRecieved_Amt(Recieved_Amt1);
                        InvoiceDetail.setBill_amt(0.0);
                        InvoiceDetail.setInvoice_By(User);
                        InvoiceDetail.setIsUsed(false);
                        
                    String msg = "Recieved Rs." + Recieved_Amt + " of " + request.getParameter("Bill_of");
                    request.setAttribute("Returnval", msg);
                    rd = request.getRequestDispatcher("Dashboard.jsp");
                    rd.forward(request, response);
                    }else{
                        response.sendRedirect("Invoice.jsp");
                    }
                    
                }//else if
            } catch (Exception e) {
                response.sendRedirect("Invoice.jsp");
            }
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

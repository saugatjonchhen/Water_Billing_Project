/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.superAdmin.col;

import com.info.model.staff;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saroj
 */
public class RegisterNewStaffCOntroller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String case1 = request.getParameter("case");
            int Case2 = 0;
            try {
                Case2 = Integer.parseInt(case1);
            } catch (Exception e) {
                Case2 = 0;
            }
            superAdminDAO superAdminDAO = new superAdminDAO();
            RequestDispatcher rd = null;

            if (Case2 == 1) {
                String Proposed_staff_id = request.getParameter("staff_id");
                Boolean isFound = true;
                if ((!Proposed_staff_id.isEmpty()) && (!case1.isEmpty())) {
                    Proposed_staff_id = Proposed_staff_id.replace(" ", "");
                    if (Proposed_staff_id.length() != 0) {
                        staff ValidStaffId = superAdminDAO.ValidStaffId(Proposed_staff_id);
                        if (ValidStaffId == null) {
                            isFound = !isFound;
                        }
                    }
                    request.setAttribute("Proposed_staff_id", Proposed_staff_id);
                    request.setAttribute("isFound", isFound);
                    rd = request.getRequestDispatcher("RegisterNewStaff.jsp");
                    rd.forward(request, response);
                } //  if ((!Proposed_staff_id.isEmpty()) && (!case1.isEmpty())) {
            } // if (Case2 == 1) {
            else if (Case2 == 2) {
                String staff_final_id = request.getParameter("staff_final_id");
                String staff_first = request.getParameter("staff_first");
                String staff_middle = request.getParameter("staff_middle");
                String staff_last = request.getParameter("staff_last");

                staff new_staffDetails = new staff();
                new_staffDetails.setStaff_id(staff_final_id);
                new_staffDetails.setStaff_pwd(staff_final_id);
                new_staffDetails.setStaff_first_name(staff_first);
                new_staffDetails.setStaff_middle_name(staff_middle);
                new_staffDetails.setStaff_last_name(staff_last);
                new_staffDetails.setRegistered_By(request.getParameter("User"));
                new_staffDetails.setBilling_control(false);
                new_staffDetails.setEdit_control(false);
                new_staffDetails.setInsert_control(false);
                new_staffDetails.setIsInService(true);
                new_staffDetails.setIsSuperAdmin(false);
                new_staffDetails.setPay_control(false);

                Boolean sucess = superAdminDAO.Insert_NewStaff_Details_Stafflogin(new_staffDetails);
                request.setAttribute("sucess", sucess);
                rd = request.getRequestDispatcher("superAdminPage.jsp");
                rd.forward(request, response);
            }
            response.sendRedirect("RegisterNewStaff.jsp");
        } catch (Exception e) {
            response.sendRedirect("RegisterNewStaff.jsp");
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

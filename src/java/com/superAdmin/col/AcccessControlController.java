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
public class AcccessControlController extends HttpServlet {

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
            String form_Staffid = request.getParameter("staff_id");
            String User = request.getParameter("User");
//            form_Staffid = form_Staffid.replaceAll("\\s", "");
            Boolean found = false;
            RequestDispatcher rd;
            try {
                if (form_Staffid.isEmpty() || form_Staffid == " ") {
                    request.setAttribute("input", form_Staffid);
                    request.setAttribute("found", found);
                    rd = request.getRequestDispatcher("AccessControl.jsp");
                    rd.forward(request, response);
                } else {
                    superAdminDAO sup = new superAdminDAO();
                    staff ValidStaffId = sup.ValidStaffId(form_Staffid);
                    if (ValidStaffId != null) {
                        if (!(ValidStaffId.getStaff_id().equalsIgnoreCase(User))) {
                            found = !found;
                            request.setAttribute("found", found);
                            request.setAttribute("staff_details", ValidStaffId);
                            rd = request.getRequestDispatcher("AccessControl.jsp");
                            rd.forward(request, response);
                        }
                    }
                        request.setAttribute("found", found);
                        rd = request.getRequestDispatcher("AccessControl.jsp");
                        rd.forward(request, response);
                    
                }
            } catch (Exception e) {
//                            rd = request.getRequestDispatcher("search.jsp");
//            rd.forward(request, response);

                response.sendRedirect("AccessControl.jsp");
            }
//            rd = request.getRequestDispatcher("search.jsp");
//            rd.forward(request, response);

//             rd = request.getRequestDispatcher("superAdminPage.jsp");
//                rd.forward(request, response);
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

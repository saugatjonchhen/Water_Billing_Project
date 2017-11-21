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

public class AcccessControlController2 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String staff_id = request.getParameter("table_id");
            Boolean sucess = false;
            RequestDispatcher rd;
            try {
                String Update = request.getParameter("Update");
                String Register = request.getParameter("Register");
                String Billing = request.getParameter("Billing");
                String Pay = request.getParameter("Pay");
                String IsinService = request.getParameter("IsinService");
                String IsSuperAdmin = request.getParameter("IsSuperAdmin");
                
                String User = request.getParameter("User"); //not used till now
                 
                int update1 = 0;
                int register1 = 0;
                int Billing1 = 0;
                int Pay1 = 0;
                int IsinService1 = 0;
                int IsSuperAdmin1 = 0;
                
                try {
                    update1 = Integer.parseInt(Update);
                } catch (Exception e) {
                    update1 = 0;
                }
                try {
                    register1 = Integer.parseInt(Register);
                } catch (Exception e) {
                    register1 = 0;
                }
                
                try {
                    Billing1 = Integer.parseInt(Billing);
                } catch (Exception e) {
                    Billing1 = 0;
                }
                try {
                    Pay1 = Integer.parseInt(Pay);
                } catch (Exception e) {
                    Pay1 = 0;
                }
                try {
                    IsinService1 = Integer.parseInt(IsinService);
                } catch (Exception e) {
                    IsinService1 = 0;
                }
                try {
                    IsSuperAdmin1 = Integer.parseInt(IsSuperAdmin);
                } catch (Exception e) {
                    IsSuperAdmin1 = 0;
                }
                

                staff staf = new staff();
                staf.setStaff_id(staff_id);

                staf.setEdit_control(false);
                if (update1 == 1) {
                    staf.setEdit_control(true);
                }

                staf.setInsert_control(false);
                if (register1 == 1) {
                    staf.setInsert_control(true);
                }
                staf.setBilling_control(false);
                if(Billing1==1){
                                    staf.setBilling_control(true);}
                staf.setPay_control(false);
                if(Pay1==1){
                    staf.setPay_control(true);
                }
                staf.setIsInService(false);
                if(IsinService1==1)
                    staf.setIsInService(true);
                staf.setIsSuperAdmin(false);
                if(IsSuperAdmin1==1)
                    staf.setIsSuperAdmin(true);

                

                superAdminDAO sup = new superAdminDAO();
                Boolean ChangeHistory = sup.ChangeHistory(User, staf);
                if(ChangeHistory)
                sucess = sup.UpdateRights(staf);
                if (sucess) {
                     request.setAttribute("sucess", sucess);
//                    response.sendRedirect("superAdminPage.jsp");
                   
                    rd = request.getRequestDispatcher("superAdminPage.jsp");
                    rd.forward(request, response);
                } else {
                      request.setAttribute("sucess", sucess);
//                    response.sendRedirect("superAdminPage.jsp");
                    rd = request.getRequestDispatcher("superAdminPage.jsp");
                    rd.forward(request, response);
                }

            } catch (Exception e) {
                response.sendRedirect("superAdminPage.jsp");
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

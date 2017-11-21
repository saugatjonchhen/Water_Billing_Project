package com.login.coll;

import com.info.model.staff;
import com.system.connection.EncryptionDecryption;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            staff staf = new staff();
            staf.setStaff_id(username);
            staf.setStaff_pwd(password);

            loginDAO login = new loginDAO();
            staff validUser = login.validUser(staf);
            HttpSession session = request.getSession(true);
            session.setAttribute("input", validUser);
            if (validUser != null) {
                String encrypt = EncryptionDecryption.encrypt(validUser.getStaff_id());
//                Cookie cookie = new Cookie("waterProject_username",validUser.getStaff_id());
                Cookie cookie = new Cookie("waterProject_username", encrypt);
                response.addCookie(cookie);
                cookie.setMaxAge(60 * 60 * 10);
                response.sendRedirect("Dashboard.jsp");
            } else {
                response.sendRedirect("index.jsp");
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

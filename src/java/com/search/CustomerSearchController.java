/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.search;

import com.info.model.customerInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saroj
 */
public class CustomerSearchController extends HttpServlet {

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
            try{
            String fname = request.getParameter("fname");
            String sname = request.getParameter("sname");
            String mname = request.getParameter("mname");
            String rdate = request.getParameter("rdate");
            String CustId = request.getParameter("Cusid");

            try{
            customerInfo cusinfo = new customerInfo();
            cusinfo.setApplicantFName(fname);
            cusinfo.setApplicantMName(mname);
            cusinfo.setApplicantLName(sname);

            searchDAO search = new searchDAO();
            List<customerInfo> list = new ArrayList();

            if ((!(fname.isEmpty())) && (fname != null)) {
                //if (!(fname.isEmpty())) {
                fname = fname.toUpperCase();
                fname = fname.concat("%");
                search.FirstName_Search(fname, list);
            }

            if ((!(mname.isEmpty())) && (mname != null)) {
                mname = mname.toUpperCase();
                mname = mname.concat("%");
                list = search.MiddleName_Search(mname, list);
            }
            if ((!(sname.isEmpty())) && (sname != null)) {
                sname = sname.toUpperCase();
                sname = sname.concat("%");
                list = search.LastName_Search(sname, list);
            }

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Date date;
            try {
                date = df.parse(rdate);
                cusinfo.setRegisteredDate(date);
                list = search.Date_Search(date, list);
            } catch (ParseException ex) {
                date = new Date();
            }

            if ((!(CustId.isEmpty())) && (CustId != null)) {
                try {
                    int cusIDD = Integer.parseInt(CustId);
                    list = search.CusID_Search(cusIDD, list);
                } catch (Exception e) {
                }
            }

            RequestDispatcher rd;

            request.setAttribute("input", cusinfo);
            List<customerInfo> final_list = new ArrayList();
            
            //removing multiple id
            if (!(list.isEmpty())) {
                List<Integer> id_only = new ArrayList<Integer>();
                for (customerInfo c : list) {
                    if (!(id_only.contains(c.getCusid()))) {
                        id_only.add(c.getCusid());
                    }
                }
                for(Integer i:id_only){
                     for (customerInfo c : list) {
                         if(i==c.getCusid()){
                             final_list.add(c);
                             break;
                         }
                     }
                }
            }
             request.setAttribute("list", final_list);
            rd = request.getRequestDispatcher("search.jsp");
            rd.forward(request, response);
            }catch(Exception q){
                response.sendRedirect("search.jsp");
            }
            }catch(Exception e){
                response.sendRedirect("Dashboard.jsp");
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

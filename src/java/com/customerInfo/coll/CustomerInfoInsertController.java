/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerInfo.coll;

import com.info.model.customerInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saroj
 */
public class CustomerInfoInsertController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            try{
                String applicant_fname = request.getParameter("ApplicantFName");
            
            String applicant_mname = request.getParameter("ApplicantMName");
            String applicant_lname = request.getParameter("ApplicantLName");
            String parent_fname = request.getParameter("ParentFName");
            String parent_mname = request.getParameter("ParentMName");
            String parent_lname = request.getParameter("ParentLName");
            String grand_parent_fname = request.getParameter("GrandParentFName");
            String grand_parent_mname = request.getParameter("GrandParentMName");
            String grand_parent_lname = request.getParameter("GrandParentLName");
            
            String NoOfMembers = request.getParameter("NoOfMembers");
            String DailyConsumption = request.getParameter("DailyConsumption");
            
            String applicants_photo = "a";
            String land_owners_photo = "a";
            String citizenship_scan_photo = "a";
            String billReceipt = "a";
            String naxa_pass_certificate = "a";
            
            
            String District = request.getParameter("District");
            String Municipality = request.getParameter("Municipality");
            String WardNumber = request.getParameter("WardNumber");
            String HouseNumber = request.getParameter("HouseNumber");
            String Street = request.getParameter("Street");
            
            String PStreet = request.getParameter("PStreet");
            String PDistrict = request.getParameter("PDistrict");
            String PMunicipality = request.getParameter("PMunicipality");
            String PWardNumber = request.getParameter("PWardNumber");
            String PHouseNumber = request.getParameter("PHouseNumber");
            String MobileNumber = request.getParameter("MobileNumber");
            String PMobileNumber = request.getParameter("PMobileNumber");
            
            String East = request.getParameter("East");
            String West = request.getParameter("West");
            String North = request.getParameter("North");
            String South = request.getParameter("South");
           
            String CitizenShipNumber = request.getParameter("CitizenShipNumber");

            if(!(applicant_fname.isEmpty())){
            applicant_fname = applicant_fname.toUpperCase();}
            if(!(applicant_mname.isEmpty()))
            applicant_mname = applicant_mname.toUpperCase();
            if(!(applicant_lname.isEmpty()))
            applicant_lname = applicant_lname.toUpperCase();
            
            customerInfo cusinfo = new customerInfo();
            cusinfo.setApplicantFName(applicant_fname);
            cusinfo.setApplicantMName(applicant_mname);
            cusinfo.setApplicantLName(applicant_lname);
            cusinfo.setParentFName(parent_fname);
            cusinfo.setParentMName(parent_mname);
            cusinfo.setParentLName(parent_lname);
            cusinfo.setGrandParentFName(grand_parent_fname);
            cusinfo.setGrandParentMName(grand_parent_mname);
            cusinfo.setGrandParentLName(grand_parent_lname);
            
            cusinfo.setApplicantPhoto(applicants_photo);
            cusinfo.setNaxaPassCertifiacte(naxa_pass_certificate);
            cusinfo.setCitizenshipScanPhoto(citizenship_scan_photo);
            cusinfo.setLandOwnerPhoto(land_owners_photo);
            cusinfo.setElectricityBillReceipt(billReceipt);
            
            java.util.Date date = new java.util.Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = java.sql.Date.valueOf(df.format(date));
            cusinfo.setRegisteredDate(date);
                   
            
            int temp;
            try {
                temp = Integer.parseInt(NoOfMembers);
            } catch (Exception e) {
                temp = 0;
            }
            cusinfo.setNoOfMembers(temp);
            
            try {
                temp = Integer.parseInt(DailyConsumption);
            } catch (Exception e) {
                temp = 0;
            }
            cusinfo.setDailyConsumption(temp);
            
            cusinfo.setMobileNumber(MobileNumber);
            cusinfo.setPMobileNumber(PMobileNumber);
            cusinfo.setCitizenShipNumber(CitizenShipNumber);

            cusinfo.setDistrict(District);
            cusinfo.setPDistrict(PDistrict);
            
            cusinfo.setHouseNumber(HouseNumber);
            cusinfo.setPHouseNumber(PHouseNumber);
            cusinfo.setWardNumber(WardNumber);
            cusinfo.setPWardNumber(PWardNumber);
            cusinfo.setStreet(Street);
            cusinfo.setPStreet(PStreet);
            
            cusinfo.setMunicipality(Municipality);
            cusinfo.setPMunicipality(PMunicipality);
            
            cusinfo.setActive(true);

            cusinfo.setEast(East);
            cusinfo.setWest(West);
            cusinfo.setNorth(North);
            cusinfo.setSouth(South);

            
            cusinfo.setRegisteredBy(request.getParameter("User"));
            
            customerDAO custDAO = new customerDAO();
            
            Boolean RetVal = custDAO.insertnewCusInfo(cusinfo);
            String tempMsg="";
            if(RetVal){
                tempMsg=tempMsg.concat(applicant_fname+" ").concat(applicant_mname+" ").concat(applicant_lname+" ");
                tempMsg = tempMsg+"added successfully to database";
            }else{
                tempMsg="!!!  Failed !!!";
            }
            request.setAttribute("Returnval", tempMsg);
            RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
            rd.forward(request, response);
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

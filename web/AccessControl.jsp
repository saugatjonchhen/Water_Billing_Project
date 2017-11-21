<%@page import="com.login.coll.loginDAO"%>
<%@page import="com.system.connection.EncryptionDecryption"%>
<%@page import="com.info.model.staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
         <style>
            .row {
    margin-right: 0 !important;
    margin-left: -15px !important;
    height: 40px !important;
    margin-top: 10px !important;
}
            input[type=checkbox], input[type=radio] {
                margin: 0px 0 0;
                margin-top: 1px\9;
                line-height: normal;
                height: 22px;}
            body {
                margin: 30px;
            }
            .mrg-15 {
                margin-bottom: 15px;
            }
            .text-center {
                margin-bottom: 15px;
            }
            @media (min-width: 1200px){
                .container {
                    width: 650px;
                }
            }
        </style>
        
    </head>
    <body>
        <% staff s = new staff();%>
        
        <%
            Cookie cookie = null;
            Cookie[] cookies = null;
            Boolean found_userID = false;
            String waterProject_username = null;
            // Get an array of Cookies associated with the this domain
            cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if ((cookie.getName().equals("waterProject_username"))) {
                        //                                                out.println("!!! Cookie found !!!");
                        if ((cookie.getValue() != null) && (cookie.getValue().length() > 0)) //               out.print("Value: " + cookie.getValue( )+" <br/>");
                        {
                            waterProject_username = cookie.getValue();
                            found_userID = !found_userID;
                        }
                    }
                }
            } else {
//                response.sendRedirect("index.jsp");
                //                                        out.println("<h2>No cookies founds</h2>");
            }
        %>
        
        <%if (!found_userID) {
                response.sendRedirect("index.jsp");
            } else {
                s = loginDAO.UserIdToFulStaff_details(EncryptionDecryption.decrypt(waterProject_username));
                if(!(s.getIsSuperAdmin()) ||(s==null)){
                     response.sendRedirect("Dashboard.jsp");
                }
        %>
        <!--<h1>Welcome,</h1>-->
        <%}%>
        
       <%
            Boolean returnResult = (Boolean) request.getAttribute("found");
            staff staff_details = (staff) request.getAttribute("staff_details");
            int casse = 0;

            if ((returnResult == null) && (staff_details == null)) {
                casse = 1;
            } else if ((returnResult != null) && (staff_details == null)) {
                casse = 2;
            } else {
                casse = 3;
            }
        %>
        <button class="btn btn-danger"><a href="superAdminPage.jsp">Back</a></button>
        
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <%if (casse != 3) {%>
                    <form class="form-horizontal" action="AcccessControlController" method="post">
                        <input type="text" name="User" hidden="" value="<%out.print(s.getStaff_id());%>">
                        <div class="form-group">
                            <label for="Name" class="col-sm-2 control-label">Staff id</label>
                            <div class="col-sm-10">
                                <input type="Text" name="staff_id" class="form-control" id="inputEmail3" placeholder="Staff id">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <button type="submit" class="btn btn-success">Search</button> 
                            </div>
                        </div>
                    </form>
                    <%} else {
                        out.print("<h4>Controls of"+" "+staff_details.getStaff_first_name() +" "+ staff_details.getStaff_middle_name() +" "+ staff_details.getStaff_last_name()+"</h4>");
                    %>

                    <form class="form-horizontal" action="AcccessControlController2" method="post">
                        <input type="text" name="User" hidden="" value="<%out.print(s.getStaff_id());%>">
                        <input type="text" value="<% out.println(staff_details.getStaff_id());%>" hidden="" name="table_id">
                        <div class="row">
                            <div class="col-sm-4">
                                <label>Update:</label></div>
                            <div class="col-sm-8">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Yes</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="Update" class="form-control" value="1" <% if (staff_details.getEdit_control()) {
                                                out.println("checked");
                                            }%>>
                                    </div>
                                    <div class="col-sm-2">
                                        <label>No</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                           <input type="radio" name="Update" class="form-control" value="0" <% if (!(staff_details.getEdit_control())) {
                                                   out.println("checked");
                                               }%>>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="col-sm-4">
                                <label>Register: </label></div>
                            <div class="col-sm-8">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Yes</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="Register" class="form-control" value="1" <% if (staff_details.getInsert_control()) {
                                                out.println("checked");}%>>
                                    </div>
                                    <div class="col-sm-2">
                                        <label>No</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="Register" class="form-control" value="0" <% if (!(staff_details.getInsert_control())) {
                                                   out.println("checked");}%>>
                                    </div>
                                </div>
                            </div>
                        </div>
                                    
                                    <div class="row">
                            <div class="col-sm-4">
                                <label>Billing: </label></div>
                            <div class="col-sm-8">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Yes</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="Billing" class="form-control" value="1" <% if (staff_details.getBilling_control()) {
                                                out.println("checked");}%>>
                                    </div>
                                    <div class="col-sm-2">
                                        <label>No</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="Billing" class="form-control" value="0" <% if (!(staff_details.getBilling_control())) {
                                                   out.println("checked");}%>>
                                    </div>
                                </div>
                            </div>
                        </div>

                                    <div class="row">
                            <div class="col-sm-4">
                                <label>Pay: </label></div>
                            <div class="col-sm-8">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Yes</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="Pay" class="form-control" value="1" <% if (staff_details.getPay_control()) {
                                                out.println("checked");}%>>
                                    </div>
                                    <div class="col-sm-2">
                                        <label>No</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="Pay" class="form-control" value="0" <% if (!(staff_details.getPay_control())) {
                                                   out.println("checked");}%>>
                                    </div>
                                </div>
                            </div>
                        </div>

                                    <div class="row">
                            <div class="col-sm-4">
                                <label>IsInService: </label></div>
                            <div class="col-sm-8">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Yes</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="IsinService" class="form-control" value="1" <% if (staff_details.getIsInService()) {
                                                out.println("checked");}%>>
                                    </div>
                                    <div class="col-sm-2">
                                        <label>No</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="IsinService" class="form-control" value="0" <% if (!(staff_details.getIsInService())) {
                                                   out.println("checked");}%>>
                                    </div>
                                </div>
                            </div>
                        </div>
                                    <div class="row">
                            <div class="col-sm-4">
                                <label>Make SuperAdmin: </label></div>
                            <div class="col-sm-8">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <label>Yes</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="IsSuperAdmin" class="form-control" value="1" <% if (staff_details.getIsSuperAdmin()) {
                                                out.println("checked");}%>>
                                    </div>
                                    <div class="col-sm-2">
                                        <label>No</label>
                                    </div>
                                    <div class="col-sm-2">                       
                                        <input type="radio" name="IsSuperAdmin" class="form-control" value="0" <% if (!(staff_details.getIsSuperAdmin())) {
                                                   out.println("checked");}%>>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-12">
                                <button type="submit" class="btn btn-success">Update</button> 
                            </div>
                        </div>
                    </form>
                    <%%>

                    <%}%>
                </div>
            </div>
        </div>
        
    </body>
</html>

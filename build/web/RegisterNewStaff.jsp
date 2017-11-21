<%@page import="com.login.coll.loginDAO"%>
<%@page import="com.system.connection.EncryptionDecryption"%>
<%@page import="com.info.model.staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width= device-width, initial-scale= 1">
        <title>Register New Customer</title>
        <!-- <link href="bootstrap.css" rel="stylesheet" type="text/css"/>
            <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/> -->
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <style>
            input[type=checkbox], input[type=radio] {
                margin: 0px 0 0;
                margin-top: 1px\9;
                line-height: normal;
                height: 22px;}
            body {
                margin: 30px;
                margin-bottom: 15px;
            }
            .text-center {
                margin-bottom: 15px;
            }
            .rowbtm-20 .row {
                margin-bottom: 20px;
            }
            .btn-default {
                padding: 15px 20px;
            }
            input {
                margin-bottom: 10px;
            }
            .btn-danger {
                padding: 15px 20px;
            }
            .form-control{
                box-shadow: none;
            }
            @media (min-width: 1200px){
                .container {
                    width: 650px;
                }
            }
            @media screen and (max-width: 660px) {
                input {
                    margin-bottom: 10px;
                }
                .btn-default {
                    padding: 10px;
                    width: 100%;
                    margin-bottom: 10px;
                }
                .btn-danger {
                    padding: 10px;
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>
        <button class="btn" style="width: 100px;"><a href="superAdminPage.jsp">Back</a></button>
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
                if(!(s.getIsSuperAdmin()) || (s==null)){
                     response.sendRedirect("Dashboard.jsp");
                }
        %>
        
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <%
                        Boolean isFound = (Boolean) request.getAttribute("isFound");
                        String Proposed_staff_id = (String) request.getAttribute("Proposed_staff_id");
                        int situation = 0;
                        if((isFound==null)&&(Proposed_staff_id==null))
                            situation=1;
                        else if((isFound==false)&&(Proposed_staff_id!=null))
                            situation=2;
                        else if((isFound==true)&&(Proposed_staff_id!=null))
                            situation=3;
                    %>
                    
                    <%if(situation!=2){%>
                    <form action="RegisterNewStaffCOntroller" method="post">
                        <input type="text" value="1" hidden="" name="case">
                         <div class="form-group">
                                <label for="email" class="col-sm-2 ">Proposed Staff ID</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="staff_id" id="inputEmail3" placeholder="Characters less than 20">
                                </div>
                            </div>
                        <div class="form-group" >
                                <div class="row">
                                    <div class="col-sm-12" style="margin-top: 3%;">
                                        <button type="submit" class="btn btn-default" style="width: 35%;">Valid</button>
                                   </div>
                                </div>
                            </div>
                    </form>
                    <%}else{%>
                    <form class="form-horizontal" action="RegisterNewStaffCOntroller" method="post">
                        <input type="text" value="2" hidden="" name="case">
                        <div class="row">
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Staff id</label>
                                <div class="col-sm-10">
                                    <input type="Text" value="<%out.println(Proposed_staff_id); ;%>" class="form-control" name="staff_final_id" id="inputEmail3" readonly="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Staff First Name</label>
                                <div class="col-sm-10">
                                    <input type="Text" required="" class="form-control" name="staff_first" id="inputEmail3" placeholder="Staff First Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Staff Middle Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="staff_middle" id="inputEmail3" placeholder="Staff Middle Name">
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Staff Last Name</label>
                                <div class="col-sm-10">
                                    <input type="text" required="" class="form-control" name="staff_last" id="inputEmail3" placeholder="Staff Last Name">
                                </div>
                            </div>
                                    <input type="text" name="User" hidden="" value="<%out.print(s.getStaff_id());%>">
                                
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-default" style="width: 35%;">Register</button>
                                        <button type="reset" class="btn btn-danger" style="float: right; width: 35%;">Reset</button> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    
                    <%}%>
                    
                </div>
            </div>
        </div>
                    <%}%>
</body>
</html>
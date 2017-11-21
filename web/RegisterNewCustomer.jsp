<%@page import="com.info.model.staff"%>
<%@page import="com.login.coll.loginDAO"%>
<%@page import="com.system.connection.EncryptionDecryption"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width= device-width, initial-scale= 1">
        <title>Register New Customer</title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
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
                 if(!(s.getInsert_control()) || (s==null)){
                     response.sendRedirect("Dashboard.jsp");
                }
           %>

        <button><a href="Dashboard.jsp" class="btn btn-block">Back to DashBoard</a></button>

        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <form class="form-horizontal" action="CustomerInfoInsertController" method="post">
                        <div class="form-group">
                            <div class="row">

                                <label class="col-sm-2 ">Applicant's Name</label>
                                <div class="col-sm-10">
                                    <div class="row">
                                        <div class="col-sm-12 col-md-4">
                                            <input type="text" name="ApplicantFName" class="form-control" id="inputEmail3" placeholder="First Name" required="">    
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <input type="text" name="ApplicantMName" class="form-control" id="inputEmail3" placeholder="Middle Name">    
                                        </div>
                                        <div class="col-sm-12 col-md-4 ">
                                            <input type="text" name="ApplicantLName" class="form-control" id="inputEmail3" placeholder="Last Name" required="">
                                        </div>         
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 ">Parent's Name</label>
                                <div class="col-sm-10">
                                    <div class="row">
                                        <div class="col-sm-12 col-md-4">
                                            <input type="text" name="ParentFName" class="form-control" id="inputEmail3" placeholder="First Name" required="">    
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <input type="text" name="ParentMName" class="form-control" id="inputEmail3" placeholder="Middle Name" >    
                                        </div>
                                        <div class="col-sm-12 col-md-4 ">
                                            <input type="text" name="ParentLName" class="form-control" id="inputEmail3" placeholder="Last Name" required="">
                                        </div>         
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 ">Grand Parent's Name</label>
                                <div class="col-sm-10">
                                    <div class="row">
                                        <div class="col-sm-12 col-md-4">
                                            <input type="text" name="GrandParentFName" class="form-control" id="inputEmail3" placeholder="First Name" required="">    
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <input type="text" name="GrandParentMName" class="form-control" id="inputEmail3" placeholder="Middle Name">    
                                        </div>
                                        <div class="col-sm-12 col-md-4 ">
                                            <input type="text" name="GrandParentLName" class="form-control" id="inputEmail3" placeholder="Last Name" required="">
                                        </div>         
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group rowbtm-20">
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>Address</label>
                                </div>
                                <div class="col-sm-4">
                                    <label>Temporary</label>
                                </div>
                                <div class="col-sm-4">
                                    <label>Permanent</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>House No:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="HouseNumber" class="form-control" placeholder="House No">
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="PHouseNumber" class="form-control" placeholder="House No">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>Ward No:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="WardNumber" class="form-control" placeholder="Ward No">
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="PWardNumber" class="form-control" placeholder="Ward No">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>Street/Tole:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="Street" class="form-control" placeholder="Street / Tole">
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="PStreet" class="form-control" placeholder="Street / Tole">
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>VDC/Municipality:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="Municipality" class="form-control" placeholder="VDC / Municipality">
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="PMunicipality" class="form-control" placeholder="VDC / Municipality">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>District:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="District" class="form-control" placeholder="District">
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="PDistrict" class="form-control" placeholder="District">
                                </div>
                            </div>
                            
                            
                            
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>Mobile No:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="MobileNumber" class="form-control" placeholder="Mobile No">
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="PMobileNumber" class="form-control" placeholder="TelePhone No">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Citizenship Number</label>
                                <div class="col-sm-10">
                                    <input type="text" name="CitizenShipNumber" class="form-control" id="inputEmail3" placeholder="CitizenShip Number">
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Number of Member</label>
                                <div class="col-sm-10">
                                    <input type="Number" name="NoOfMembers" class="form-control" id="inputEmail3" placeholder="Number of member">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Daily Consumption</label>
                                <div class="col-sm-10">
                                    <input type="Number" name="DailyConsumption" class="form-control" id="inputEmail3" placeholder="Expected Daily Consumption">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">

                                <label class="col-sm-2 ">Char Killa Information</label>
                                <div class="col-sm-10">
                                    <div class="row">
                                        <div class="col-sm-12 col-md-4">
                                            <input type="text" name="East" class="form-control" id="inputEmail3" placeholder="East">    
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <input type="text" name="West" class="form-control" id="inputEmail3" placeholder="West" >    
                                        </div>
                                        <div class="col-sm-12 col-md-4 ">
                                            <input type="text" name="North" class="form-control" id="inputEmail3" placeholder="North">
                                        </div>         
                                        <div class="col-sm-12 col-md-4 ">
                                            <input type="text" name="South" class="form-control" id="inputEmail3" placeholder="South">
                                        </div>         
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input hidden="" name="User" value="<%out.print(s.getStaff_id());%>">
                        <div class="form-group">
                            <div class="row">

                                <div class="col-sm-12">
                                    <button type="submit" class="btn btn-default" style="width: 35%;">Register</button>

                                    <button type="reset" class="btn btn-danger" style="float: right; width: 35%;">Reset</button> 
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%}%>
    </body>
</html>
<%@page import="com.info.model.BillingDetails"%>
<%@page import="com.info.model.staff"%>
<%@page import="com.login.coll.loginDAO"%>
<%@page import="com.system.connection.EncryptionDecryption"%>
<%@page import="com.bill.cols.BiilingDAO"%>

<%@page import="com.info.model.customerInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Reading Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <style>
            .FormMatra {
                margin-top: 2%;
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
                    if (!(s.getBilling_control()) || (s == null)) {
                        response.sendRedirect("Dashboard.jsp");
                    }
            %>


            <br>
            <button class="btn btn-danger" style="margin-left: 5%"><a href="Bill.jsp">Back to DashBoard</a></button>
                <%
                    BiilingDAO BilDAO = new BiilingDAO();
                    Boolean IsFound = (Boolean) request.getAttribute("isFound");
                    String Message = (String) request.getAttribute("Message");
                    customerInfo CustomerInfomation = (customerInfo) request.getAttribute("CustomerInfo");
                    BillingDetails Customer_LastReading_Details = (BillingDetails) request.getAttribute("lastReading_Row");
                %>

                <%if ((IsFound != null) && (Message != null)) {
                %>
                <script>
                    alert("<%out.print(Message);%>");
                </script>
                <%}%>

                <div class="test">
                    <div class="container">
                        <div class="FormMatra">
                            <form method="post" action="insertReadingController">
                                <input type="number" name="case" hidden="" value="1">
                                <div class="form-group">
                                    <label class="col-sm-2 col-form-label" >Enter the Customer ID</label>
                                    <div class="col-sm-2">
                                        <input type="number" name="CustomerId" class="form-control form-control-warning" placeholder="Customer id">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="offset-sm-2 col-sm-10">
                                        <button type="submit" class="btn btn-primary" style="    width: 165px;">Check</button>
                                </div>
                            </div>
                        </form>   
                    </div>

                    <%if (IsFound != null && CustomerInfomation != null) {%>
                    <table class="table table-striped table-bordered table-responsive">
                        <th>Consumer Id</th>
                        <th>Name</th>
                        <th>Parent's Name</th>
                        <th>Address</th>
                        <tr>
                            <td style="color: red; font-size: large;"><%out.println(CustomerInfomation.getCusid());%></td>
                            <td style="color: red; font-size: large;"><%out.println(CustomerInfomation.getApplicantFName() + " " + CustomerInfomation.getApplicantMName() + " " + CustomerInfomation.getApplicantLName());%></td>
                            <td><%out.println(CustomerInfomation.getParentFName() + " " + CustomerInfomation.getParentMName() + " " + CustomerInfomation.getParentLName());%></td>
                            <td><%out.println("House No:" + CustomerInfomation.getHouseNumber() + " " + CustomerInfomation.getStreet() + ", " + CustomerInfomation.getMunicipality() + "-" + CustomerInfomation.getWardNumber() + "," + CustomerInfomation.getDistrict());%></td>
                        </tr>
                    </table>
                    <br>

                    <%if (Customer_LastReading_Details != null) {%>
                    <form action="insertReadingController" method="post">
                        <table class="table table-striped table-responsive">
                            <th>Present Reading Name</th>
                            <th>Previous Reading</th>
                            <th>Status</th>
                            <th>Present Reading</th>
                            <tr>
                                <td><%out.print(Customer_LastReading_Details.getBill_Name());%></td>
                                <td><%out.print(Customer_LastReading_Details.getReading_Value());%></td>
                                <td><select name="status" class="form-group">
                                        <option value="1">Normal</option>
                                        <option value="2">Door-Lock</option>
                                    </select>
                                </td>
                                <td>
                                    <input type="text" name="CustomerId" hidden="" value="<%out.print(CustomerInfomation.getCusid());%>">
                                    <input type="text" name="Bill_Name" hidden="" value="<%out.print(Customer_LastReading_Details.getBill_Name());%>">
                                    <input type="text" name="Bill_by_id" hidden="" value="<%out.print(s.getId());%>">
                                    <input type="text" name="Last_Unit" hidden="" value="<%out.print(Customer_LastReading_Details.getReading_Value());%>">
                                    <input type="Number" name="case" hidden="" value="2">
                                    <input type="Number" name="Units" style="width: -webkit-fill-available;" placeholder="Enter here..........." required="">
                                    <button type="submit" class="form-control" style="color: black; background-color: rgba(0, 204, 255, 0.41); margin-top: 4px;">Process</button>
                            </form>
                            </td>
                            </tr>
                        </table>
                        <%}%>

                        <%}%>
                </div>
            </div>
            <%
//                s.getStaff_first_name();
                }
            %>
        </body>
    </html>

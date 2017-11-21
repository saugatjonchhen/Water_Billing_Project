<%@page import="com.login.coll.loginDAO"%>
<%@page import="com.system.connection.EncryptionDecryption"%>
<%@page import="com.info.model.staff"%>
<%@page import="com.info.model.BillingDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.info.model.customerInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Bill</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <style>
            .FormMatra {
                margin-top: 2%;
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
                if (!(s.getPay_control()) || (s == null)) {
                    response.sendRedirect("Dashboard.jsp");
                }
        %>


        <br>
        <button class="btn btn-danger" style="margin-left: 5%"><a href="Bill.jsp">Back to DashBoard</a></button>
        <%
            Boolean IsFound = (Boolean) request.getAttribute("isFound");
            String Message = (String) request.getAttribute("Message");
            customerInfo CustomerInfomation = (customerInfo) request.getAttribute("CustomerInfo");
            ArrayList<BillingDetails> Get_AllRemaining_Bills = (ArrayList) request.getAttribute("AllRemaining_Bills");
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
                    <form method="post" action="InvoiceController">
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
                <form method="post" action="InvoiceController">
                    <table class="table table-striped table-bordered table-responsive">
                        <th style="width: 105px;">Customer ID</th>
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
                    <table class="table table-striped table-bordered table-responsive">
                        <th style="width: 35px;">S.N </th>
                        <th>Due Date</th>
                        <th>Amount</th>
                        <th>Fine/Discount</th>
                        <th>Total</th>

                        <%
                            int i = 0;
                            Double Total = 0.0;
                            Double Fine_Disc = 0.0;
                            String Sign = "+";
                            for (BillingDetails BillDetail : Get_AllRemaining_Bills) {
                                i++;
                                Total = Total + BillDetail.getInvoice_Amt();
                                Fine_Disc = BillDetail.getFine();
                                if (BillDetail.getDiscount() > 0) {
                                    Fine_Disc = BillDetail.getDiscount();
                                    Sign = "-";
                                }
                        %>
                        <tr>
                            <td> <%out.println(i);%> </td>
                            <td> <%out.println(BillDetail.getBill_Name());%> </td>
                            <td> <%out.println(BillDetail.getReading_Bill());%> </td>
                            <td> <%out.println(Sign + Fine_Disc);%> </td>
                            <td> <%out.println(BillDetail.getInvoice_Amt());%> </td>
                        </tr>
                        <% }%>
                        <tr>
                            <td colspan="4" style="text-align: center;font-size: 17px;">Grand Total</td>
                            <td><%out.println(Total);%></td>
                        </tr>
                        <tr>
                        <input type="number" name="case" hidden="" value="2">
                        <td colspan="4" style="text-align: center;font-size: 17px;">Receved Amount</td>
                        <td><input type="number" name="Recieved_Amt"></td>
                        </tr>
                        <tr>
                            <td colspan="4" style="text-align: center;font-size: 17px;"></td>
                            <td><button type="submit" class="btn btn-primary" style="    width: 165px;">Pay</button></td>
                        </tr>
                        <input hidden="" type="text" name="Bill_of" value="<%out.print(CustomerInfomation.getApplicantFName()+" "+CustomerInfomation.getApplicantMName()+" "+CustomerInfomation.getApplicantLName());%>">
                        <input hidden="" type="text" name="Bill_of_id" value="<%out.print(CustomerInfomation.getCusid());%>">
                        <input hidden="" type="text" name="User" value="<%out.print(s.getId());%>">
                    </table>
                </form>
                <%}%>



            </div>
        </div>
        <%}%>
    </body>
</html>

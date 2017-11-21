<%@page import="java.util.List"%>
<%@page import="com.info.model.customerInfo"%>
<%@page import="com.info.model.customerInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <%
            List<customerInfo> returnList = (List<customerInfo>) request.getAttribute("list");
            customerInfo mod = (customerInfo) request.getAttribute("input");
        %>

        <div class="container" style="margin: 30px;">
            <div class="row">
                <div class="col-sm-12">
                    <form action="CustomerSearchController" method="POST" class="form-horizontal">
                        <div class="row">
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">First Name:</label>
                                <div class="col-sm-10">
                                       <input type="text" class="form-control" name="fname" value="<%if (mod != null) {
                                            out.print(mod.getApplicantFName());}%>">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Surname:</label>
                                <div class="col-sm-10">
                                       <input type="text" name="sname" class="form-control" value="<%if (mod != null) {
                                               out.print(mod.getApplicantLName());}%>">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Middle Name:</label>
                                <div class="col-sm-10">
                                       <input type="text" class="form-control" name="mname" value="<%if (mod != null) {
                                               out.print(mod.getApplicantMName());}%>">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Customer id:</label>
                                <div class="col-sm-10">
                                    <input type="Number" name="Cusid" class="form-control">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group">
                                <label for="email" class="col-sm-2 ">Registered date:</label>
                                <div class="col-sm-10">
                                    <input type="text" placeholder="yyyy-mm-dd" name="rdate" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">   

                                <div class="col-sm-12">
                                    <button type="submit" class="btn btn-default">Submit</button>
                                    <button class="btn btn-danger" style="float: right"><a href="Dashboard.jsp" style="color: white">Back to DashBoard</a></button> 
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%if (returnList != null) {%>
        <div class="container" style="margin-top: 50px">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>S.N</th>
                        <th>Customer Id</th>
                        <th>Name</th>
                        <th>mobile no</th> 
                        <th>Address</th>
                        <th>Registered Date</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%if (returnList.isEmpty()) {%>
                <h1 style="text-align: center">No data found</h1>
                <%} else {
                    int i = 0;
                    for (customerInfo model : returnList) {
                        i++;%>
                <td><%=i%> </td>
                <td><%out.println(model.getCusid());%></td>
                <td><% out.println(model.getApplicantFName() + " " + model.getApplicantMName() + " " + model.getApplicantLName());%></td>
                <td> <% out.println(model.getMobileNumber());%></td>
                <td> <% out.println("House No: " + model.getPHouseNumber()+ " Ward no: " + model.getPWardNumber()+ ", " + model.getPStreet()+ " ," + model.getPMunicipality()+", "+model.getPDistrict());%></td>
                <td><% out.println(model.getRegisteredDate());%> </td>
                </tr>
                <%} //for closing%>
                </tbody>
            </table>
            <%} }%>
        </div>

    </body>

</html>

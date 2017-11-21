<%@page import="com.system.connection.EncryptionDecryption"%>
<%@page import="com.login.coll.loginDAO"%>
<%@page import="com.info.model.staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DashBoard Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
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
                 if(s==null){
                    response.sendRedirect("Dashboard.jsp");
                }
        %>

        <%
            String Returnval = (String) request.getAttribute("Returnval");
        %>

        <%if (Returnval != null) {%>
        <script>
            alert("<%out.print(Returnval);%>");
        </script>
        <%  }
        %>
        <h1>Welcome,
            <%
                out.print(s.getStaff_first_name() + " " + s.getStaff_middle_name() + " " + s.getStaff_last_name());
            %>
        </h1>

        <div class="container">
            
            <%
                if (s.getIsSuperAdmin()) {
            %>
            <div>
                <button type="button" class="btn">
                    <a href="superAdminPage.jsp">SuperAdmin DashBoard </a>
                </button>
            </div>
            <%}%>
            
            <br>
            <%
                if (s.getInsert_control()) {
            %>
            <div>
                <button type="button" class="btn">
                    <a href="RegisterNewCustomer.jsp">Add New Customer   </a>
                </button>
            </div>
            <%}%>
            
            <br>
            <%if (s.getEdit_control()) {%>
            <div>
                <button type="button" class="btn">
                    <a href="#">Update customer Detail</a>
                </button>
            </div>
            <%}%>
            
            <br>
            <%if (s.getBilling_control()) {%>
            <div>
                <button type="button" class="btn">
                    <a href="Bill.jsp">Bill</a>
                </button>
            </div>
            <%}%>
            
             <br>
            <%if (s.getPay_control()) {%>
            <div>
                <button type="button" class="btn">
                    <a href="Invoice.jsp
                       ">Pay</a>
                </button>
            </div>
            <%}%>
            
            <br>
            <div>
                <button type="button" class="btn">
                    <a href="search.jsp">Search </a>
                </button>
            </div>
            <br>
            <br>
            <br>
            <button type="button" class="btn btn-danger"><a href="LogOtControllers">Log Out</a></button>
        </div>
        <%}%>
    </body>
</html>

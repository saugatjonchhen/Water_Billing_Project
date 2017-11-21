<%@page import="com.login.coll.loginDAO"%>
<%@page import="com.system.connection.EncryptionDecryption"%>
<%@page import="com.info.model.staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            a {
    color: #000000;
    text-decoration: none;
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
                if((s==null)||!(s.getBilling_control())){
                    response.sendRedirect("Dashboard.jsp");
                }
        %>
        <button class="btn btn-danger" style="    margin-top: 20px;margin-left: 25px;width: 90px;"><a href="Dashboard.jsp">Back</a></button>
        
        <%if(s.getBilling_control()){%>
        <div class="container" style="margin: 3%;">
            <div>
                <button type="button" class="btn">
                    <a href="insertReading.jsp">Insert Reading</a>
                </button>
            </div>
            <br>
            
            <div>
                <button type="button" class="btn">
                    <a href="#">Update Reading</a>
                </button>
            </div>
            <br>
            
            <div>
                <button type="button" class="btn">
                    <a href="#">Reading History</a>
                </button>
            </div>
            <br>
         </div>
        <%}else{
            response.sendRedirect("index.jsp");
        }%>
        <%} //cookie closing%>
    </body>
</html>

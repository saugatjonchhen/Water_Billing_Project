<%@page import="com.login.coll.loginDAO"%>
<%@page import="com.system.connection.EncryptionDecryption"%>
<%@page import="com.info.model.staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Super admin Page</title>
        <!--<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
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
                if(!(s.getIsSuperAdmin()) || (s==null)){
                     response.sendRedirect("Dashboard.jsp");
                }
        %>
        <!--<h1>Welcome,</h1>-->
        <%}%>
        
        
        <%Boolean sucess = (Boolean) request.getAttribute("sucess");%>
        <%
            if (sucess != null) {
                if (sucess) {%>
        <script>
            alert("!! Update Successful!! ")
        </script>
        <%} else { %>
        <script>
            alert("!! Failed !! ")
        </script>

        <%    //else ending here
                }
            }
        %>


        <h2>Super Admin Page</h2>
         <div class="container">
            
            <div>
                <button type="button" class="btn">
                    <a href="AccessControl.jsp">Access Control of Staff</a>
                </button>
            </div>
             <br>
             
              <div>
                <button type="button" class="btn">
                    <a href="RegisterNewStaff.jsp">Register New Staff</a>
                </button>
            </div>
             <br>
             
              <div>
                <button type="button" class="btn">
                    <a href="#">Search Staff</a>
                </button>
            </div>
             <br>
            <div>
                <button type="button" class="btn btn-danger">
                    <a href="Dashboard.jsp">Back to DashBoard</a>
                </button>
            </div>
             <!--closing of container div-->
           </div>  
      
                
    </body>
</html>

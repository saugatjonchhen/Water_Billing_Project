<%-- 
    Document   : newjsptest
    Created on : Nov 10, 2017, 5:26:43 PM
    Author     : Saroj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script>
            $('#all').click(function(event) {   
    if(this.checked) {
        // Iterate each checkbox
        $(':checkbox').each(function() {
            this.checked = true;                        
        });
    }
});
        </script>
    </head>
    <body>
        <input type="checkbox" name="checkbox-1" id="checkbox" />1
<input type="checkbox" name="checkbox-2" id="checkbox" />2
<input type="checkbox" name="checkbox-3" id="checkbox" />3

<!-- select all boxes -->
<input type="checkbox" name="all" id="all" />
    </body>
</html>
    
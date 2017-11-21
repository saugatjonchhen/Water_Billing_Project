<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
         <script>
            function popupCenter(url, title, w, h) {
                url='photos/IMG_8688.JPG';
                var left = (screen.width / 2) - (w / 2);
                var top = (screen.height / 2) - (h / 2);
                return window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);
            }
        </script>

        <script>
            function ClickedMe(){
//                 url='photos/IMG_8688.JPG';
//                 url = $("#testt").val();
//                 var url =document.getElementById("asdf").value;
              
                 var url =$("#asdf").val();
//                  url ="photos/IMG_8688.JPG";
 var w = 450;
                var h=450;
                var left = (screen.width / 2) - (w / 2);
                var top = (screen.height / 2) - (h / 2);
               
                var title="fuck";
                return window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);
            }
        </script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <%String testt="photos/test.jpg";%>
        
        <input type="text" id="asdf" name="asdf" value="<%out.println(testt);%>">
        
        
        <button onclick="ClickedMe()">tesssssssssssssssssssssssssssst</button>
        
          <!--<a onclick="popupCenter('<%out.println(testt);%>','as', 450, 450);" href="javascript:void(0);">CLICK TO OPEN POPUP</a>-->    
          <!--<button onclick="popupCenter('as','asd',450,450)">sdfsdf</button>-->
          
          
          
          
          
          
</body>
</html>

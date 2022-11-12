<%-- 
    Document   : footer
    Created on : Feb 22, 2021, 10:55:13 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/footer.css" rel="stylesheet" type="text/css"/>
        <title>Footer</title>
        <%String[] array = new String[5];%> 
    </head>
    <body>
        <div class="footer">
            <div class="footer-content">
                <p><a href="#">Create with Simple Site</a></p>

                <div class="button">    
                    <%String view = (String) session.getAttribute("s");%>


                    <%String num = String.valueOf(view);
                        array = num.split("");
                    %>
                    <%
                    for (int i = 0; i < array.length; i++) {%>
                    <button><%=array[i]%></button>
                    <%}%>

                </div>
            </div>
        </div>
    </body>
</html>

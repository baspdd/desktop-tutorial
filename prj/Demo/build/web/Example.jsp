<%-- 
    Document   : Example
    Created on : May 25, 2022, 1:30:22 PM
    Author     : duypham0705
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        // Đây là scriptlet
        // nơi chứa code gióng java
        String msg = "Hello world ! ";
        out.println(msg);
//         Khởi tạo 2 biến số nguyên a,b
//         hiển thị các kết quả a+b
//        int a=Integer.parseInt(request.getParameter("a"));
        int a=Integer.parseInt(request.getParameter("a"));
        int b=Integer.parseInt(request.getParameter("b"));
        out.println(a+b);
        out.println("<br>");
        out.println(a-b);
        out.println("<br>");
        out.println(a*b);
        out.println("<br>");
        out.println(a/b);
        out.println("<br>");
        out.println(a%b);
        out.println("<br>");



        %>
        <br>a=<%=a%>

        <%!
        //global var
        String msg = "Hello JSP";
        %>

    </body>
</html>

<%-- 
    Document   : error
    Created on : Feb 23, 2021, 7:50:34 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/home.css" rel="stylesheet" type="text/css"/>
        <title>Error</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="main-body">
            <div class="main-body-content">
                <h1>${errorMessage}</h1>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>

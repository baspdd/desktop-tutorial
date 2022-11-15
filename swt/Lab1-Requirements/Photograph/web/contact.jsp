<%-- 
    Document   : contact
    Created on : Feb 23, 2021, 4:29:39 PM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/contact.css" rel="stylesheet" type="text/css"/>
        <title>Contact</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="main-body">
            <div class="main-body-content">
                <div class="main-body-content-left">                
                    <div>Contact</div>
                    <div>PHOTOGRAPHER</div>
                    <div>Address: ${information.address}</div>
                    <div>City: ${information.city}</div>
                    <div>Country: ${information.country}</div>
                    <div>Tel:${information.tel}</div>
                    <div>Email: ${information.email}</div>     
                    <div>
                        <img src="${information.image}"/>
                    </div>
                </div>
                <div class="main-body-content-right">
                    <%@include file="right.jsp"%>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>

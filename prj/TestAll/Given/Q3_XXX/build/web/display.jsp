<%-- 
    Document   : display
    Created on : Dec 11, 2019, 8:42:50 AM
    Author     : sonnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.*"  %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <c:forEach items = "${data}" var="item" >
            <div>
                ${item.getContent()}
                <c:forEach items = "${item.getAnswers()}" var="te" >
                    <div style="margin-left: 40px;">
                        ${te.getContent()}
                    </div>
                </c:forEach>
            </div>
        </c:forEach>

    </body>
</html>

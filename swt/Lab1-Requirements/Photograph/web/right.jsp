<%-- 
    Document   : right
    Created on : Feb 23, 2021, 10:01:28 AM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/right.css" rel="stylesheet" type="text/css"/>
        <title>Right</title>
    </head>
    <body> 
        <div class="right">
            <div class="share-title">
                <p>Share this page</p>
            </div>
            <div class="list-social-network">
                <c:forEach var="s" items="${ShareList}" >
                    <div class="social-network-link">
                        <img src="${s.icon}" alt=""/>
                        <a href="${s.url}">Share on ${s.socialNetwork}</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>

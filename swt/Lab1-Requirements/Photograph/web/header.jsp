<%-- 
    Document   : header
    Created on : Feb 22, 2021, 10:54:53 PM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/header.css" rel="stylesheet" type="text/css"/>
        <title>Header</title>
    </head>
    <body>
        <div class="pre-header">
            <div class="pre-header-content">
                <ul>
                    <li><a class="${boldHome}" href="Home">My front page</a></li>
                    <c:forEach var="x" items="${Top3Gallery}">
                        <c:if test="${x.id==id}">
                        <li><a class="font-bold" href="GalleryDetail?id=${x.id}">${x.name}</a></li>
                        </c:if>
                        <c:if test="${x.id!=id}">
                        <li><a class="" href="GalleryDetail?id=${x.id}">${x.name}</a></li>
                        </c:if>
                    </c:forEach>   
                    <li><a class="${boldContact}" href="Contact">Contact</a></li>                
                </ul>
            </div>
        </div>
        <div class="header"> 
            <div class="header-content">
                <a><img src="public/images/icon.png" /></a>
                <div class="app-title">
                    <div class="app-name">
                        <a href="Home">PHOTOGRAPHER</a>
                    </div>
                    <div class="app-welcome">
                        Welcome to this website.
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

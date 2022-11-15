<%-- 
    Document   : index
    Created on : Feb 22, 2021, 10:54:21 PM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/home.css" rel="stylesheet" type="text/css"/>
        <title>Home</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="main-body">
            <div class="main-body-content">
                <div class="main-body-content-left">
                    <!--intro image, description-->
                    <div class="intro">
                        <div class="intro-image"><img src="${Introduction.image}"/></div>
                        <div class="intro-descript">${Introduction.description}</div>
                    </div>
                    <!--link view gallery-->
                    <div class="view-gallery">
                        <c:forEach var="g" items="${PagingGallery}" >
                             <div class="a-gallery">
                                <div class="a-gallery-image">
                                    <img  src="${g.image}" alt="" >
                                </div>
                                <div class="a-gallery-name">
                                    <a  href="GalleryDetail?id=${g.id}">View ${g.name}</a>
                                </div>
                                <div class="a-gallery-description">
                                    ${g.description}
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    
                    <!--show page index-->
                    
                    <div class="paging">
                        <c:forEach var="i" begin="1" end="${numberPage}">
                            <!--page current-->
                            <c:if test="${i == page}">
                                <p>${i}</p>
                            </c:if>
                            <!--other pages:If clicked, it will move to a new page-->
                            <c:if test="${i != page}">
                                <a href="Home?page=${i}" >${i}</a>
                            </c:if>
                        </c:forEach>
                    </div>
                    
                    <!--about me -->
                    <div class="about-me">
                        <div class="about-me-title">About me</div>
                        <p class="about-me-content">
                            ${Introduction.aboutMe}
                        </p>
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

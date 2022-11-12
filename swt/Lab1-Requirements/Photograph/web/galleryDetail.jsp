<%-- 
    Document   : galleryDetail
    Created on : Feb 23, 2021, 10:29:51 PM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="public/css/galleryDetail.css" rel="stylesheet" type="text/css"/>
        <script src="public/js/clickImage.js" type="text/javascript"></script>
        <title>Gallery Detail</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="main-body">
            <div class="main-body-content">
                <div class="main-body-content-left"> 
                    <c:if test="${galleryCurrent!= null}"> 
                        <!--gallery title-->
                        <div class="galleryCurrentName">${galleryCurrent.name}</div>
                        <!--big image-->
                        <div class="galleryCurrentImage">
                            <img id="galleryCurrentClick" src="${galleryCurrent.image}" onclick="myFunction();"/>
                            <img src="public/images/play.png" style="display: block" id="btnPause" class="btn-pause-play" alt=""/>
                            <script  type="text/javascript">
                                var refreshIntervalId;
                                let index = 0;
                                let interval = 2000;
                                function slide() {
                                    image.src = img_array[index++ % img_array.length];
                                }
                                window.onload = function() {
                                }
                                let image = document.getElementById("galleryCurrentClick");
                                let img_array = [];
                                <c:forEach items="${imgGalleryList}" var="img">
                                img_array.push("${img.image}");
                                </c:forEach>
                                    
                                function myFunction() {                                    
                                    let status = document.getElementById("btnPause").style.display;
                                    if(status == "block"){
                                        document.getElementById("btnPause").style.display = "none";
            
                                       refreshIntervalId =  setInterval(slide, interval);
                                    }else{
                                        document.getElementById("btnPause").style.display = "block";
                                       clearInterval(refreshIntervalId);
                                    }
                                }
                            </script>

                        </div>
                        <!--other images-->
                        <div class="otherImage">
                            <c:forEach items="${imgGalleryList}" var="img">
                                <div class="sub-gallery">
                                    <div class="sub-img">
                                        <img id="${img.image}" src="${img.image}" alt="" onclick="imageOnClick(this.id)" />
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <!--page index-->
                        <div class="paging">
                            <c:forEach var="i" begin="1" end="${numberPage}">
                                <!--page current-->
                                <c:if test="${i == page}">
                                    <p>${i}</p>
                                </c:if>
                                <!--other pages:If clicked, it will move to a new page-->
                                <c:if test="${i != page}">
                                    <a href="GalleryDetail?page=${i}&id=${galleryCurrent.id}" >${i}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </c:if>
                </div>
                <div class="main-body-content-right">
                    <%@include file="right.jsp"%>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>

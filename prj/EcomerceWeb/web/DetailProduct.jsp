

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Detail Product</title>
        <!-- Roboto Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
        <!-- Material Design Bootstrap -->
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
        <!-- Material Design Bootstrap Ecommerce -->
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
        <!-- Your custom styles (optional) -->

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
        </style>
    </head>
    <body class="skin-light">
        <jsp:include page="Menu.jsp"></jsp:include>

            <div class="jumbotron color-grey-light mt-70">
                <div class="d-flex align-items-center h-100">
                    <div class="container text-center py-5">
                        <h3 class="mb-0"></h3>
                    </div>
                </div>
            </div>

            <!--Main Navigation-->

            <!--Main layout-->
            <main>
                <div class="container">

                    <!--Section: Block Content-->
                    <section class="mb-5">

                        <div class="row">
                            <div class="col-md-6 mb-4 mb-md-0">

                                <div id="mdb-lightbox-ui"></div>

                                <div class="mdb-lightbox">

                                    <div class="row product-gallery mx-1">

                                        <div class="col-12 mb-0">
                                            <figure class="view overlay rounded z-depth-1 main-img" style="max-height: 450px;">
                                                <a href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15a.jpg"
                                                   data-size="710x823">
                                                    <img src="${detail.image}"
                                                     class="img-fluid z-depth-1" style="margin-top: -90px;">
                                            </a>
                                        </figure>
                                        <figure class="view overlay rounded z-depth-1" style="visibility: hidden;">
                                            <a href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg"
                                               data-size="710x823">
                                                <img src="${detail.image2}"
                                                     class="img-fluid z-depth-1">
                                            </a>
                                        </figure>
                                        <figure class="view overlay rounded z-depth-1" style="visibility: hidden;">
                                            <a href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13a.jpg"
                                               data-size="710x823">
                                                <img src="${detail.image3}"
                                                     class="img-fluid z-depth-1">
                                            </a>
                                        </figure>
                                        <figure class="view overlay rounded z-depth-1" style="visibility: hidden;">
                                            <a href="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/14a.jpg"
                                               data-size="710x823">
                                                <img src="${detail.image4}"
                                                     class="img-fluid z-depth-1">
                                            </a>
                                        </figure>
                                    </div>
                                    <div class="col-12">
                                        <div class="row">
                                            <div class="col-3">
                                                <div class="view overlay rounded z-depth-1 gallery-item hoverable" >
                                                    <img src="${detail.image}"
                                                         class="img-fluid">
                                                    <div class="mask rgba-white-slight"></div>
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="view overlay rounded z-depth-1 gallery-item hoverable">
                                                    <img src="${detail.image2}"
                                                         class="img-fluid">
                                                    <div class="mask rgba-white-slight"></div>
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="view overlay rounded z-depth-1 gallery-item hoverable">
                                                    <img src="${detail.image3}" 
                                                         class="img-fluid">
                                                    <div class="mask rgba-white-slight"></div>
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="view overlay rounded z-depth-1 gallery-item hoverable">
                                                    <img src="${detail.image4}" 
                                                         class="img-fluid">
                                                    <div class="mask rgba-white-slight"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>

                        </div>
                        <div class="col-md-6">

                            <h5>${detail.product_name}</h5>

                            <p><span class="text-grey"><strong>${detail.displayPrice()}</strong></span></p>
                            <p class="pt-1">${detail.description}</p>
                            <div class="table-responsive">
                                <table class="table table-sm table-borderless mb-0">
                                    <tbody>
                                        <tr>
                                            <th class="pl-0 w-25" scope="row"><strong>Model</strong></th>
                                            <td>${detail.model }</td>
                                        </tr>
                                        <tr>
                                            <th class="pl-0 w-25" scope="row"><strong>Color</strong></th>
                                            <td>${detail.color }</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <hr>

                            <form action="addCart?pid=${detail.product_id}" method="post">
                                <div class="table-responsive mb-2">
                                    <table class="table table-sm table-borderless">
                                        <tbody>
                                            <tr>
                                                <td class="pl-0 pb-0 w-25">Quantity</td>
                                            </tr>
                                            <tr>
                                                <td class="pl-0">
                                                    <div class="mt-1">
                                                        <div class="def-number-input number-input safari_only mb-0" style="display: flex; align-items: center;">
                                                            <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                                    class="minus"></button>
                                                                    <input class="quantity" min="0" name="quantity" value="1" type="number" id="number">
                                                            <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                                    class="plus"></button>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="mt-1">
                                    <button type="submit" class="btn btn-primary btn-md mr-1 mb-2">Buy now</button>
                                    <button  type="button" onclick="addToCartByAjax(${detail.product_id})" class="btn btn-light btn-md mr-1 mb-2"><i class="fas fa-shopping-cart pr-2"></i>Add to
                                        cart</button>
                                </div>
                            </form>

                        </div>
                    </div>

                </section>
                <!--Section: Block Content-->

                <!-- Classic tabs -->
                <div class="classic-tabs">

                    <ul class="nav tabs-primary nav-justified" id="advancedTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active show" id="description-tab" data-toggle="tab" href="#description" role="tab"
                               aria-controls="description" aria-selected="true">Description</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="info-tab" data-toggle="tab" href="#info" role="tab" aria-controls="info"
                               aria-selected="false">Information</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="reviews-tab" data-toggle="tab" href="#reviews" role="tab" aria-controls="reviews"
                               aria-selected="false">Reviews (${countAllReview })</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="advancedTabContent">
                        <div class="tab-pane fade show active" id="description" role="tabpanel" aria-labelledby="description-tab">
                            <h5>Product Description</h5>

                            <h6>${detail.displayPrice()}</h6>
                            <p class="pt-1">${detail.description}</p>
                        </div>
                        <div class="tab-pane fade" id="reviews" role="tabpanel" aria-labelledby="reviews-tab">
                            <h5><span>${countAllReview }</span> review for <span>${detail.product_name}</span></h5>

                            <h5 class="mt-4">Add a review</h5>
                            <p></p>

                            <div>
                                <!-- Your review -->
                                <div class="md-form md-outline">
                                    <textarea id="form76" class="md-textarea form-control pr-6" rows="4"></textarea>
                                    <label for="form76">Your review</label>
                                </div>
                                <div class="text-right pb-2">
                                    <button type="button" class="btn btn-primary" onclick="addReview(${detail.product_id})">Add a review</button>
                                </div>
                            </div>



                            <c:forEach items="${listAllReview}" var="r">

                                <div class="media mt-3 mb-4">
                                    <img class="d-flex mr-3 z-depth-1" src="https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg"
                                         width="62" alt="Generic placeholder image">
                                    <div class="media-body">
                                        <div class="d-flex justify-content-between">
                                            <p class="mt-1 mb-2">
                                                <c:forEach items="${listAllAcount}" var="a">
                                                    <c:if test="${r.account_id == a.id }">
                                                        <strong>${a.username } </strong>
                                                    </c:if>
                                                </c:forEach>
                                                <span>– </span><span>${r.date_review}</span>
                                            </p>
                                        </div>
                                        <p class="mb-0">${r.content}</p>
                                    </div>
                                </div>
                                <hr>    

                            </c:forEach>


                        </div>



                    </div>

                </div>
                <!-- Classic tabs -->

                <hr>

                <!--Section: Block Content-->
                <section class="text-center">

                    <h4 class="text-center my-5"><strong>Related products</strong></h4>

                    <!-- Grid row -->
                    <div class="row">

                        <c:forEach items="${listRelatedProduct}" var="o">
                            <!-- Grid column -->
                            <div class="col-md-6 col-lg-3 mb-5">

                                <!-- Card -->
                                <div class="">

                                    <div class="view zoom overlay z-depth-2 rounded">
                                        <img class="img-fluid w-100"
                                             src="${o.image }" alt="Sample">
                                        <a href="detail?pid=${o.product_id}">
                                            <div class="mask">
                                                <img class="img-fluid w-100"
                                                     src="${o.image }">
                                                <div class="mask rgba-black-slight"></div>
                                            </div>
                                        </a>
                                    </div>

                                    <div class="pt-4">

                                        <h5>${o.tiltle}</h5>
                                        <p><span class="text-grey"><strong>${o.displayPrice()}</strong></span></p>
                                    </div>
                                </div>
                                <!-- Card -->

                            </div>
                            <!-- Grid column -->
                        </c:forEach>

                    </div>
                    <!-- Grid row -->

                </section>
                <!--Section: Block Content-->

            </div>
        </main>
        <!--Main layout-->
        <jsp:include page="Footer.jsp"></jsp:include>
        <script>
            window.addEventListener("load", function loadAmountCart() {
                $.ajax({
                    url: "/EcomerceWeb/loadAllAmountCart",
                    type: "get", //send it through get method
                    data: {

                    },
                    success: function (responseData) {
                        document.getElementById("amountCart").innerHTML = data;
                    }
                });
            }, false);

            function addReview(pID) {
                var cntReview = document.getElementById("form76").value;
                $.ajax({
                    url: "/EcomerceWeb/addReview",
                    type: "get", //send it through get method
                    data: {
                        productID: pID,
                        contentReview: cntReview
                    },
                    success: function (data) {
                        var row = document.getElementById("reviews");
                        row.innerHTML += data;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
            
            function addToCartByAjax(pID){
                var number = $("#number").val();
                $.ajax({
                    url: "/EcomerceWeb/addToCartByAjax",
                    type: 'GET',
                    data: {
                        productID : pID,
                        number : number
                    },
                    success: function (data) {
                        alert('AddSuccessful!!');
                        document.getElementById("amountCart").innerHTML = data;
                    }
                });
            }
        </script>
        <!-- SCRIPTS -->
        <!-- JQuery -->
        <script src="../../../js/jquery-3.4.1.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
        <!-- MDB Ecommerce JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
        <script>
                 $(document).ready(function () {
                     // MDB Lightbox Init
                     $(function () {
                         $("#mdb-lightbox-ui").load("../../../mdb-addons/mdb-lightbox-ui.html");
                     });
                 });
        </script>
    </body>
</html>

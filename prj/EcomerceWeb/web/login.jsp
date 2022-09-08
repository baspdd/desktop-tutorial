<%-- 
    Document   : login
    Created on : Dec 21, 2020, 9:06:39 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script
            src="https://kit.fontawesome.com/64d58efce2.js"
            crossorigin="anonymous"
        ></script>
        <link rel="stylesheet" href="css/smart.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <title>Sign in & Sign up Form</title>
    </head>
    <body>
        <div class="container">
            <div class="forms-container">
                <div class="signin-signup">
                    <c:set var="cookie" value="${pageContext.request.cookies}"/>
                    <form action="LoginController" class="sign-in-form" method="POST">
                        <h2 class="title">Sign in</h2>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="textbox" name="username" placeholder="Username" value="${cookie.name.value}">
                        </div>
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input type="password" name="password" placeholder="Password" value="${cookie.pass.value}">
                        </div>
                        <p>${requestScope.error}</p>
                        <a href="Forgotpassword.jsp" id="forget-pass">FORGOT PASSWORD???</a>
                        <input type="submit" value="Login" class="btn solid" />
                    </form>
                    <form action="Signup" class="sign-up-form" method="post">
                        <!--<form action="verify" class="sign-up-form" method="POST">-->
                        <h2 class="title">Sign up</h2>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="textbox" onkeyup="checkUserNameExist()" id="username" name="username" placeholder="Username" required>
                        </div>
                        <input disabled type="text" style="background-color: white;color: red;width: 250px;border: none" id="usernamestatus" >
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="email" onkeyup="checkEmailExist()" id="email" name="email" placeholder="Email" required >
                        </div>
                        <input disabled type="text" style="background-color: white;color: red;width: 250px;border: none" id="emailstatus">
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input id = "phone" type="textbox" name="signupphone" placeholder="Phone Number" required pattern="^[0-9]{10,11}$" 
                                   oninvalid="this.setCustomValidity('Phone must be 10-11 numbers')" 
                                   oninput="this.setCustomValidity('')"/>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input type="password" name="password" required placeholder="Password" id="pw">
                        </div>
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input type="password" placeholder="Re-type Password" required name="repassword" id="pw2">
                        </div>
                        <div class="input-field">
                            <i class="fas fa-key"></i>
                            <input type="text" placeholder="OTP" required name="OTP" id="otp" onkeyup="checkOTP()">
                        </div>
                        <input disabled type="text" style="background-color: white;color: red;width: 250px;border: none" id="sendOTP" >
                        <button onclick="sendMail()" name="button" type="button" class="btn" >Send Mail</button>
                        <input type="submit" class="btn" value="Sign up" onclick="return checkValid();"/>
                        <input disabled type="text" style="background-color: white;color: red;width: 250px;border: none" id="error" >
                    </form>
                </div>
            </div>
            <script type="text/javascript">

                function checkUserNameExist() {
                    var username = $('#username').val();
                    $.ajax({
                        url: "/EcomerceWeb/check",
                        type: 'POST',
                        data: {username: username},
                        success: function (response) {
                            document.getElementById("usernamestatus").value = response;

                        },
                        error: function () {
                            alert("error");
                        }
                    });
                }

                function checkEmailExist() {
                    var email = $('#email').val();
                    $.ajax({
                        url: "/EcomerceWeb/checkEmailExist",
                        type: 'POST',
                        data: {email: email},
                        success: function (response) {
                            document.getElementById("emailstatus").value = response;

                        },
                        error: function () {
                            alert("error");
                        }
                    });
                }

                function checkValid() {
                    var i = document.getElementById("emailstatus").value;
                    var j = document.getElementById("usernamestatus").value;
                    var k = document.getElementById('sendOTP').value;
                    var pass = document.getElementById('pw').value;
                    var repass = document.getElementById('pw2').value;
                    if (j === "User was existed" || i === "Email was exist" || pass !== repass) {
                        document.getElementById('error').value = "Please check again!";
                        return false;
                    }
                    if (k === "Input wrong otp") {
                        return false;
                    }
                    return true;
                }

                function sendMail() {

                    var email = $('#email').val();
                    $.ajax({
                        url: "/EcomerceWeb/SendOTP",
                        type: 'POST',
                        data: {email: email},
                        success: function (response) {
                            document.getElementById('sendOTP').value = response;
                        },
                        error: function () {
                            alert("error");
                        }
                    });
                }
                function checkOTP() {
                    var otp = $('#otp').val();
                    $.ajax({
                        url: "/EcomerceWeb/checkOTP",
                        type: 'POST',
                        data: {
                            otp: otp
                        },
                        success: function (response) {
                            document.getElementById('sendOTP').value = response;
                        }
                    });
                }
            </script>
            <div class="panels-container">
                <div class="panel left-panel">
                    <div class="content">
                        <h3>New here ?</h3>
                        <p>
                            Share the good things to everyone over the world!
                        </p>
                        <button class="btn transparent" id="sign-up-btn">
                            Sign up
                        </button>
                    </div>
                    <img src="img/log.svg" class="image" alt="" />
                </div>
                <div class="panel right-panel">
                    <div class="content">
                        <h3>One of us ?</h3>
                        <p>
                            Share the good things to everyone over the world!
                        </p>
                        <button class="btn transparent" id="sign-in-btn">
                            Sign in
                        </button>
                    </div>
                    <img src="img/register.svg" class="image" alt="" />
                </div>
            </div>
        </div>
        <script src="js/app.js"></script>
    </body>
</html>
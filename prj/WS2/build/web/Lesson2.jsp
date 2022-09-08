<%-- Document : Test2 Created on : Mar 3, 2020, 8:32:20 PM Author : tienpro --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test 02</title>
        <style>
            * {
                font-size: 25px;
            }
        </style>
    </head>

    <body>
        <form name="form2" action="Lesson2">
            <table style="border:2px solid green;margin:auto">
                <tr>
                    <td colspan='3' align='center' width="500px">
                        <b>
                            <label style="font-size:30px;font-weight:bold;color:orange">
                                PRIME NUMBER
                            </label>
                        </b>
                    </td>
                </tr>
                <tr>
                    <td><br></td>
                </tr>
                <tr>
                    <td><i><b>Enter an integer n:</b></i></td>
                </tr>
                <tr>
                    <td><br></td>
                </tr>
                <tr>
                    <td align='center'>
                        <input type='text' id='a' name="numberInput" onkeyup="search()" value="${n}" style="width:400px">

                        <input type="button" onclick="reload()" value="RESET"
                               style="font-size:20px;font-weight:bold;color:red"></input>
                        <br>
                        <span id="span">${ret}</span>
                        <br>
                        <!--<input disabled id="b" type="text" value="${ret}">-->
                        <script>
                            function reload() {
                                document.getElementById("a").value = "";
                                document.getElementById("span").textContent = "";
//                                document.getElementById("b").value = "";
                                document.getElementById("c").value = "";
                            }
                            var request = new XMLHttpRequest();
                            function search() {
                                var numberInput = document.form2.numberInput.value;
                                var url = "Lesson2?numberInput=" + numberInput;

                                try {
                                    request.onreadystatechange = function () {
                                        if (request.readyState == 4) {
                                            var el = document.createElement('html');
                                            el.innerHTML = request.responseText;

                                            var val = el.getElementsByTagName("span")[0].textContent;
                                            if (val == "Enter an integer n")
                                                document.getElementById("a").value = "";
//                                            document.getElementById("b").value = val;
                                            document.getElementById("span").textContent = val;
                                        }
                                    }//end of function  
                                    request.open("GET", url, true);
                                    request.send();
                                } catch (e) {
                                    alert("Unable to connect to server");
                                }
                            }
                        </script>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td><br></td>
                </tr>
                <tr>
                    <td align='center'><b>Show n prime numbers >= n</b></td>
                </tr>
                <tr>
                    <td align='center'>
                        <input type="submit" name="prime" value="  --V--  "
                               style="font-size:20px;font-weight:bold;color:red">
                    </td>
                </tr>
                <tr>
                    <td><br></td>
                </tr>
                <tr>
                    <td align='center'>
                        <input disabled type='text' id="c" style="width:350px;" value="${pri}"">
                    </td>
                </tr>
                <tr>
                    <td><br></td>
                </tr>
            </table>
        </form>
    </body>

</html>
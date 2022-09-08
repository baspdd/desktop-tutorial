<%-- 
    Document   : Test3
    Created on : Mar 3, 2020, 8:36:02 PM
    Author     : tienpro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test 03</title>
        <style>
            *{
                font-size:25px;

            }
        </style>
    </head>
    <body>
        <form name="form3" action="Lesson3">
            <table style="border:2px solid orange;margin:auto">
                <tr>
                    <td colspan='3' align='center'>
                        <b>
                            <label style="font-size:30px;font-weight:bold;color:blue">
                                INPUT AND CALCULATE
                            </label>
                        </b>
                    </td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><i><b>Enter an integer n:</b></i></td>
                    <td rowspan='8'>
                        <textarea rows='7' cols='10' id="c">${ret}</textarea>
                    </td>
                </tr>
                <tr>
                    <td><input type='text'  id='a' name='numberInput' onkeyup="search()" value="${n}" style="width:150px">
                        <input type='submit' name="set" value='  >>  '></input></td>
                    <td></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td align='center'>
                        <input type="button" value="RESET" onclick="reload()" style="font-size:20px;font-weight:bold;color:red">
                    </td>
                    <td></td>
                </tr>
                <script>
                    function reload() {
                        document.getElementById("a").value = "";
                        document.getElementById("b").value = "";
                        document.getElementById("c").value = "";
                    }
                    var request = new XMLHttpRequest();
                    function search() {
                        var numberInput = document.form3.numberInput.value;
                        var url = "Lesson3?numberInput=" + numberInput;

                        try {
                            request.onreadystatechange = function () {
                                if (request.readyState == 4) {
                                    var el = document.createElement('html');
                                    el.innerHTML = request.responseText;

                                    var val = el.getElementsByTagName("textarea")[0].value;
                                    if (val == "Enter an integer n")
                                        document.getElementById("a").value = "";
                                    document.getElementById("c").value = val;
                                }
                            }//end of function  
                            request.open("GET", url, true);
                            request.send();
                        } catch (e) {
                            alert("Unable to connect to server");
                        }
                    }
                </script>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><b>Sum of numbers in list:</b></td>

                    <td><input type='text' id="b" value="${sum}" style="width:175px;"></input></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>

            </table>
        </form>
    </body>
</html>

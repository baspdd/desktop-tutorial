<%-- 
    Document   : index
    Created on : Jun 29, 2022, 1:59:12 PM
    Author     : duypham0705
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.*"  %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ListStudentController">
            Add new Student:<br>
            ID : <input type="text" name="id" value="${id}"><br>
            Name : <input type="text" name="name" value="${name}"><br>
            Gender : <input type="radio" name="sex" value="male" >
            <input type="radio" name="sex" value="female"><br>

            Department :<select name="type" id="selection" >
                <option value=""></option>
                <option value="1">Information Technology</option>
                <option value="2">Business Administration</option>
                <option value="3">Data Science</option>
                <option value="4">Marketing and PR</option>
            </select>      
            <br>
            <input type="submit" name="submit" value="add">                   
        </form>
        <table border="1">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>gender</td>
                <td>department</td>
            </tr>
            <c:forEach items = "${listAll}" var="item" >
                <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.isGender()}</td>
                    <td>${item.getDepartmentName()}</td>
                </tr>
            </c:forEach>
        </table>


    </body>
</html>

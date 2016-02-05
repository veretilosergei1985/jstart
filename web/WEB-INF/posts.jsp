<%-- 
    Document   : posts
    Created on : Feb 3, 2016, 8:17:08 PM
    Author     : sveretilo
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>${post.id}</td>
                    <td><c:out value="${post.txt}"/></td>
                    <td><a href="delete?id=${post.id}">Delete</a></td>
                </tr>
            </c:forEach>
            <tr>
            <form action="/Test1/add" method="POST">
                <input type="text" name="txt">
                <input type="submit">             
            </form>
            </tr>
        </table>
    </body>
</html>

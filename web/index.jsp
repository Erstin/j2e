<%-- 
    Document   : index
    Created on : Jan 6, 2012, 7:10:18 PM
    Author     : bargenson
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupSMS</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty user}">
                <!-- L'utilisation de c:url permet de ne pas mettre le nom de domaine en prefix -->
                <c:url value="/logout" var="logoutUrl" />
                <a href="${logoutUrl}">Logout</a>
            </c:when>
            <c:otherwise>
                <c:url value="/login" var="loginUrl" />
                <a href="${loginUrl}">Login</a>
            </c:otherwise>
        </c:choose>
    </body>
</html>

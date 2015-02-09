<%@ attribute name="ongletTitle" required="false" type="java.lang.String" description="Title of the onglet" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Base Template" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="res/css/bootstrap-theme.min.css" />
        <link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="res/css/custom.css" />
        <script language="javascript" type="text/javascript" src="res/js/jquery.1.11.2.min.js"></script>
        <script language="javascript" type="text/javascript" src="res/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            <c:if test="${! empty ongletTitle}">
                ${ongletTitle}
            </c:if>
            <c:if test="${empty ongletTitle}">
                SupSMS
            </c:if>
        </title>
    </head>
    <body>
        <div class="container-fluid">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">SupSMS</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <div class="nav navbar-nav navbar-left">
                            <c:url value="/home" var="homeUrl" />
                            <a href="${homeUrl}" class="btn btn-default navbar-btn" style="float:left">
                                <img src="res/img/home.jpg" width="20px" height="20px"/>
                            </a>
                            <c:if test="${not empty user}">
                                <ul class="nav navbar-nav">
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Actions possibles<span class="caret"></span></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li>
                                                <c:url var="manageContactUrl" value="/contacts" />
                                                <a href="${manageContactUrl}">G&eacute;rer mes contacts</a>
                                            </li>
                                            <li>
                                                <c:url var="manageSmsUrl" value="/smsManager" />
                                                <a href="${manageSmsUrl}">G&eacute;rer mes messages</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </c:if>
                        </div>
                        <div class="nav navbar-nav navbar-right" id="log">
                            <c:choose>
                                <c:when test="${not empty user}">
                                    <c:url value="/logout" var="logInOrOut" />
                                    <c:set value="Logout" var="logVar" />
                                </c:when>
                                <c:otherwise>
                                    <c:url value="/login" var="logInOrOut" />
                                    <c:set value="Login" var="logVar" />
                                    <c:url value="/signin" var="signIn" />
                                    <a class="btn btn-default navbar-btn" href="${signIn}">Sign In</a>
                                </c:otherwise>
                            </c:choose>
                            <a class="btn btn-default navbar-btn" href="${logInOrOut}">${logVar}</a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        <jsp:doBody/>
    </body>
</html>
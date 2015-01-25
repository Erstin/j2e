<%@ attribute name="ongletTitle" required="false" type="java.lang.String" description="Title of the onglet" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Base Template" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="res/css/bootstrap-theme.min.css" />
        <link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css" />
        <script language="javascript" type="text/javascript" src="res/js/jquery.1.11.2.min.js"></script>
        <script language="javascript" type="text/javascript" src="res/js/bootstrap.min.js"></script>
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
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <c:choose>
                        <c:when test="${not empty user}">
                            <ul class="nav navbar-nav">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">G&eacute;rer Contacts</a></li>
                                        <li><a href="#">Envoyer un message</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </c:when>
                    </c:choose>
                    <div class="nav navbar-nav navbar-right">
                        <c:choose>
                            <c:when test="${not empty user}">
                                <c:url value="/logout" var="logInOrOut" />
                                <c:set value="Logout" var="logVar" />
                            </c:when>
                            <c:otherwise>
                                <c:url value="/login" var="logInOrOut" />
                                <c:set value="Login" var="logVar" />
                            </c:otherwise>
                        </c:choose>
                        <a class="btn btn-default navbar-btn" href="${logInOrOut}">${logVar}</a>
                    </div>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <jsp:doBody/>
    </body>
</html>
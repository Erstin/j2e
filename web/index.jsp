<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:body>
    <h1>SupSMS</h1>
    <p>
        Bienvenu sur SupSMS, le gestionnaire web de vos contacts et SMS
        &agrave; partir d'un platform supinfo.</p>
    <p>
        Cette platform vous permet de g&eacute;rer vos contacts manuellement et
        d'envoyer et de recevoir des sms. Il est &eacute;galement possible de
        synchroniser directement les informations que vous souhaitez pour 10$
        par mois.
    </p>
    <h1>Informations Statistiques</h1>
    <p> 
        Il y a ${nbUser} utilisateurs connectés.<br />
        <c:if test="${not empty nbContact and not empty nbSMS}">
            Vous avez ${nbContact} contacts et ${nbSMS} sms.
        </c:if>
    </p>
</t:body>
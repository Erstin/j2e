<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading" id="panel-title">
                        <h2>SupSMS</h2>
                    </div>
                    <div class="panel-body">
                        <p>
                            Bienvenue sur SupSMS, le gestionnaire web de vos contacts et SMS
                            &agrave; partir d'une plateforme SupInfo.</p>
                        <p>
                            Cette plateforme vous permet de g&eacute;rer vos contacts manuellement et
                            d'envoyer et de recevoir des sms. Il est &eacute;galement possible de
                            synchroniser directement les informations que vous souhaitez pour 10$
                            par mois.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading" id="panel-title">
                        <h2>Informations Statistiques</h2>
                    </div>
                    <div class="panel-body">    
                        <p> 
                            Il y a ${nbUser} utilisateurs connectés.<br />
                            <c:if test="${not empty nbContact and not empty nbSMS}">
                                Vous avez ${nbContact} contacts et ${nbSMS} sms.
                            </c:if>
                            <c:if test="${empty nbContact}">
                                Il y a ${nbSMS} sms qui transite avec cette application.
                            </c:if>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:body>
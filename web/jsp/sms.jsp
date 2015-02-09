<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<t:body ongletTitle="${ongletTitle}">
    <div class="row" id="sms">
        <div class="col-md-4">
            <div class="panel panel-default" id="addContact">
                <div class="panel-heading" id="panel-title">
                    <h3>Envoyer un message</h3>
                </div>
                <div class="panel-body">
                    <form method="GET">
                        <div class="form-group">
                            <label>Num&eacute;ro de t&eacute;l&eacute;phone</label>
                            <input type="text" name="phoneNumber" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Message</label>
                            <textarea name="message" class="form-control"></textarea>
                        </div>
                        <div class="form-group">
                            <input type="hidden" name="_method" value="PUT">
                            <button type="submit" value="Ajouter" class="btn btn-primary">Envoyer</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="panel panel-default" id="addContact">
                <div class="panel-heading" id="panel-title">
                    <h3>Voir mes messages</h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <tbody>
                                <thead>
                                    <th>Num&eacute;ro de t&eacute;l&eacute;phone</th>
                                    <th>Dernier message</th>
                                </thead>

                                <c:forEach items="${senders}" var="sender">
                                    <tr>
                                        <c:url var="smsUrl" value="/sms?phone=${sender.key.phoneNumber}" />
                                        <td>
                                            <a href="${smsUrl}">${sender.key.phoneNumber}</a>
                                        </td>
                                        <td>
                                            ${sender.value.message}
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:body>
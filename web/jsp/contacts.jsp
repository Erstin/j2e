<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<t:body ongletTitle="${ongletTitle}">
    <div class="row" id="contacts">
        <div class="col-md-2">
            <div class="panel panel-default" id="addContact">
                <div class="panel-heading" id="panel-title">
                    <h3>Ajouter un contact</h3>
                </div>
                <div class="panel-body">
                    <form method="GET">
                        <div class="form-group">
                            <label>Numéro de téléphone</label>
                            <input type="text" name="phoneNumber" class="form-control "/>

                            <input type="hidden" name="_method" value="PUT">
                            <button type="submit" value="Ajouter" class="btn btn-primary">Ajouter</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-10">
            <div class="panel panel-default" id="manageContacts">
                 <div class="panel-heading" id="panel-title">
                    <h3>Voir / Gérer ses contacts</h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <th>Num&eacute;ro de t&eacute;l&eacute;phone</th>
                                <th>Pseudo</th>
                                <th>E-mail</th>
                                <th>Adresse</th>
                                <th>Action</th>
                            </thead>
                        <c:forEach items="${contacts}" var="contact">
                            <tr>
                                <c:url var="contactUrl" value="/contacts?phone=${contact.phoneNumber}" />
                                <td>
                                    <a href="${contactUrl}">${contact.phoneNumber}</a>
                                </td>
                                <td>
                                    <a href="${contactUrl}">${contact.username}</a>
                                </td>
                                <td>
                                    <a href="${contactUrl}">${contact.email}</a>
                                </td>
                                <td>${contact.address.streetNumber} ${contact.address.street.streetName}<br />
                                    ${contact.address.street.cityName} - ${contact.address.street.zipCode}
                                </td>
                                <td>
                                    <form method="DELETE">
                                        <input type="hidden" name="phoneNumber" value="${contact.phoneNumber}" />
                                        <input type="hidden" name="_method" value="DELETE">
                                        <input type="submit" value="Supprimer" class="alert alert-danger"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:body>
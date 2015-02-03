<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<t:body ongletTitle="${ongletTitle}">
    <form method="GET">
        <div class="form-group">
            <label>Numéro de téléphone</label>
            <input type="text" name="phoneNumber" />

            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="Ajouter" class="alert alert-info" />
        </div>
    </form>
    <table class="table table-striped">
        <th>
        <td>Num&eacute;ro de t&eacute;l&eacute;phone</td>
        <td>Pseudo</td>
        <td>E-mail</td>
        <td>Adresse</td>
    </th>
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
</t:body>
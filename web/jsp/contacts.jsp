<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<t:body ongletTitle="${ongletTitle}">
    <table class="table table-striped">
        <th>
            <td>Num&eacute;ro de t&eacute;l&eacute;phone</td>
            <td>Pseudo</td>
            <td>E-mail</td>
            <td>Adresse</td>
        </th>
        <c:forEach items="${contacts}" var="contact">
            <tr>
                <td>${contact.phoneNumber}</td>
                <td>${contact.username}</td>
                <td>${contact.email}</td>
                <td>${contact.address.streetNumber} ${contact.addresse.street.streetName}<br />
                    ${contact.addresse.street.cityName} - ${contact.addresse.street.zipCode}
                </td>
            </tr>
        </c:forEach>
    </table>
</t:body>
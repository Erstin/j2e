<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<t:body ongletTitle="${ongletTitle}">
    <form method="GET">
        <div class="form-group">
            <label>Num&eacute;ro de t&eacute;l&eacute;phone</label>
            <input type="text" name="phoneNumber" />
        </div>
        <div class="form-group">
            <label>Message</label>
            <textarea name="message"></textarea>
        </div>
        <div class="form-group">
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="Ajouter" class="alert alert-info" />
        </div>
    </form>
    <table class="table table-striped">
        <th>
        <td>Num&eacute;ro de t&eacute;l&eacute;phone</td>
        <td>Dernier message</td>
    </th>
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
</table>
</t:body>
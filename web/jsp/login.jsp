<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:body ongletTitle="${ongletTitle}">
    <form method="POST">
        <label for="username">Username :</label>
        <input type="text" name="username" /><br />
        <label for="password">Password :</label>
        <input type="password" name="password" /><br />
        <input type="submit" value="Submit" />
    </form>
</t:body>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:body ongletTitle="${ongletTitle}">
    <form method="POST">
        <div class="form-group">
            <label for="username">Username :</label>
            <input type="text" name="username" />
        </div>
        <div class="form-group">
            <label for="password">Password :</label>
            <input type="password" name="password" />
        </div>
        <input type="submit" value="Connection" />
    </form>
</t:body>
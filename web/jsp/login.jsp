<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:body ongletTitle="${ongletTitle}">
    ${ongletTitle}
    <form method="POST">
            <div>
                <label for="username">Username :</label>
                <input type="text" name="username" />
            </div>
            <div>
                <label for="password">Password :</label>
                <input type="password" name="password" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div>
        </form>
</t:body>
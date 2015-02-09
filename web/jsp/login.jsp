<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:body ongletTitle="${ongletTitle}">
    <div class="panel panel-default" id="login">
        <div class="panel-body">
            <form method="POST">
                <div class="form-group">
                    <label for="username">Username :</label>
                    <input type="text" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password :</label>
                    <input type="password" name="password" class="form-control" />
                </div>
                <button class="btn btn-primary" type="submit" value="Connection">Connexion</button>
            </form>
        </div>
    </div>
</t:body>
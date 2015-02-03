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
        <div class="form-group">
            <label for="phonenumber">Phone number :</label>
            <input type="number" name="phonenumber" />
        </div>
        <div class="form-group">
            <label for="lastname">Last name :</label>
            <input type="text" name="lastname" />
        </div>
        <div class="form-group">
            <label for="firstname">First name :</label>
            <input type="text" name="firstname" />
        </div>
        <div class="form-group">
            <label for="email">E-mail :</label>
            <input type="email" name="email" />
        </div>
        <div class="form-group">
            <label for="streetnumber">Street number :</label>
            <input type="number" name="streetnumber" />
        </div>
        <div class="form-group">
            <label for="streetname">Street name :</label>
            <input type="text" name="streetname" />
        </div>
        <div class="form-group">
            <label for="cityname">City :</label>
            <input type="text" name="city" />
        </div>
        <div class="form-group">
            <label for="zipcode">ZIP code :</label>
            <input type="text" name="zipcode" />
        </div>

        <input type="submit" value="Send" />
    </form>
</t:body>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:body ongletTitle="${ongletTitle}">
    <form method="POST">
        <label for="username">Username :</label>
        <input type="text" name="username" /><br />
        <label for="password">Password :</label>
        <input type="password" name="password" /><br />
        <label for="phonenumber">Phone number :</label>
        <input type="number" name="phonenumber" /><br />
        <label for="lastname">Last name :</label>
        <input type="text" name="lastname" /><br />
        <label for="firstname">First name :</label>
        <input type="text" name="firstname" /><br />
        <label for="email">E-mail :</label>
        <input type="email" name="email" /><br />
        <label for="streetnumber">Street number :</label>
        <input type="number" name="streetnumber" /><br />
        <label for="streetname">Street name :</label>
        <input type="text" name="streetname" /><br />
        <label for="cityname">City :</label>
        <input type="text" name="city" /><br />
        <label for="zipcode">ZIP code :</label>
        <input type="text" name="zipcode" /><br />

        <input type="submit" value="Submit" />
    </form>
</t:body>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:body ongletTitle="${ongletTitle}">
    <div class="panel panel-default" id="signin">
        <div class="panel-body">
            <form method="POST">
                <div class="row">
                    <div class="col-md-12">
                        <fieldset>
                            <legend>Account</legend>
                            <div class="form-group">
                                <label for="username">Username :</label>
                                <input type="text" name="username" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="password">Password :</label>
                                <input type="password" name="password" class="form-control" />
                            </div>
                        </fieldset>
                    </div>
                    <div class="col-md-6">
                        <fieldset>
                            <legend>Civilian and Phone Informations</legend>
                            <div class="form-group">
                                <label for="phonenumber">Phone number :</label>
                                <input type="number" name="phonenumber" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="lastname">Last name :</label>
                                <input type="text" name="lastname" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="firstname">First name :</label>
                                <input type="text" name="firstname" class="form-control" />
                            </div>
                        </fieldset>
                    </div>
                    <div class="col-md-6">
                        <fieldset>
                            <legend>Mail and Addresses</legend>
                            <div class="form-group">
                                <label for="email">E-mail :</label>
                                <input type="email" name="email" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="streetnumber">Street number :</label>
                                <input type="number" name="streetnumber" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="streetname">Street name :</label>
                                <input type="text" name="streetname" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="cityname">City :</label>
                                <input type="text" name="city" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="zipcode">ZIP code :</label>
                                <input type="text" name="zipcode" class="form-control" />
                            </div>
                        </fieldset>
                    </div>
                    
                </div>
                <button class="btn btn-primary " type="submit" value="Send">S'inscrire</button>
            </form>
        </div>
    </div>
</t:body>
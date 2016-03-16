<%-- 
    Document   : connexion_inscription
    Created on : 16 mars 2016, 14:21:36
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="connexion">
    <form method="post" action="connexion_servlet">
        <label>Login</label><input type="text" name="login"/>
        <label>Password</label><input type="password" name="password"/>
        <input type="submit" value="Connexion">
    </form>
</div>

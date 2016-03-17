<%-- 
    Document   : connexion_inscription
    Created on : 16 mars 2016, 14:21:36
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div>
    <form method="post" action="connexion_servlet">
        <label>Login</label><input type="text" name="login"/> <br/>
        <label>Password</label><input type="password" name="password"/> <br/>
        <input type="submit" value="Connexion">
    </form>
    <a href="inscription.jsp">Inscription</a>
</div>

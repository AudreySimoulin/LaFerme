<%-- 
    Document   : connexion
    Created on : 15 mars 2016, 13:59:24
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>La Ferme en Folie</title>
        <c:import url="_CSS.jsp"/>
    </head>
    <body>
        <c:import url="_TITRE.jsp"/>
        <c:import url="_MENU.jsp"/>
        <div class="contenu">
            <h2>Connexion</h2>
            <form method="post" action="connexion_servlet">
                <table>
                    <tr>
                        <td><label>Login</label></td>
                        <td><input type="text" name="login"/></td>
                    </tr>
                    <tr>
                        <td><label>Password</label></td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                </table> 
                <input type="submit"/>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
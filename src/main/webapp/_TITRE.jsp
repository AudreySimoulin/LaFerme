<%-- 
    Document   : _TITRE
    Created on : 15 mars 2016, 13:58:40
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="titre"> </div>

<div class="connexion">
    <c:choose>
        <c:when test="${sessionScope.login==null}">
            <a href="inscription.jsp">Inscription</a>
            <a href="connexion.jsp">Se Connecter</a>
        </c:when>
        <c:otherwise>
            Bonjour ${sessionScope.login} !
            <br/>
            <a href="ma_ferme_servlet">Ma Ferme</a>
            <br/>
            <a href="deconnexion_servlet">D&eacute;connexion</a>
        </c:otherwise>
    </c:choose>

</div>

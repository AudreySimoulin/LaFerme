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
            <c:import url="connexion_inscription.jsp"/> <br/><br/><br/>
        </c:when>
        <c:otherwise>
            Bienvenue dans votre ferme ${sessionScope.login} !
            <br/>
            <a href="deconnexion_servlet">D&eacute;connexion</a>
        </c:otherwise>
    </c:choose>

</div>

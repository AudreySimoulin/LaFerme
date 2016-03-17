<%-- 
    Document   : homepage
    Created on : 15 mars 2016, 13:58:26
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
    <body class="bodyHome">
        <c:import url="_TITRE.jsp"/>
        <div class="contenu">
            <c:if test="${sessionScope.login!=null}">
            <a href="la_ferme_servlet"><input type="button" name="jouer" value="jouer" class="boutonHome"/></a> 
            </c:if>
        </div>
        <div class="titre"> <h4>La Ferme en Folie<h4/> </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>


<%-- 
    Document   : echanger
    Created on : 18 mars 2016, 14:33:03
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
    <body class="bodyFerme">
        <c:import url="_TITRE.jsp"/>
        <div class="nutrition">
            <form method="post" action="echanger_servlet">
                <table>
                    <tr>
                        <td><label>Ressources disponibles</label></td>
                        <td><label>Ressources souhait&eacute;es</label></td>
                    </tr>
                    <tr>
                        <td>
                            <select name="ressourceAvendre">
                                <c:forEach items="${ressourcesAvendre}" var="ressourceAvendre">
                                    <option value="${ressourceAvendre.id}">${ressourceAvendre.typeRessource}</option> 
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select name="typeRessourceAacheter">
                                <c:forEach items="${typeRessourcesAacheter}" var="typeRessourceAacheter">
                                    <option value="${typeRessourceAacheter}">${typeRessourceAacheter}</option> 
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Echanger"/>
            </form>
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>

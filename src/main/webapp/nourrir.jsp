<%-- 
    Document   : nourrir
    Created on : 17 mars 2016, 13:50:05
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
        <div class="contenu">
            <a href="la_ferme_servlet"><input type="button" value="Retour au jeu"></a>
            <br>
            <table>
                <tr>
                    <td>
                        Bouche(s) à nourrir
                    </td>
                    <td>
                        Ech&eacute;ance de mort
                    </td>
                    <td>
                        Nourriture disponible
                    </td>                
                </tr>
                <c:forEach items="${bouchesAnourrir}" var="oucheAnourrir">
                    <form action="nourrir_servlet?boucheAnourrir=${boucheAnourrir.id}" method="post">
                        <tr>
                            <td>                                
                                ${boucheAnourrir.typeRessource}
                            </td>
                            <td>
                                ${boucheAnourrir.dateFinCycle}
                            </td>
                            <td>
                                <select name="nourriture">
                                    <c:forEach items="nourritures" var="nourriture">
                                        <option value="${nourriture.id}">${nourriture.typeRessource}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <input type="submit" value="Nourrir">
                            </td>
                        </tr>     
                    </form>

                </c:forEach>

            </table>   
        </div>
        <c:import url="_PIED.jsp"/>
    </body>
</html>

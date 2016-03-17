<%-- 
    Document   : la_ferme
    Created on : 16 mars 2016, 14:41:44
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
        <script type="text/javascript">
            var task = function (){
                document.location.reload();
            }
            window.setTimeout(task,1000);
        </script>
    </head>
    <body class="bodyFerme">
        <c:import url="_TITRE.jsp"/>
        <%-- //Cadran Date Jeu--%>
        <div class="dateJeu">             
            <img src="Images/calendar.png" alt=""/> <br/>
            ${dateJeu}
        </div>

        <%-- //Bouton Echanger ressource--%>
        <a href="echanger_ressource_servlet"><input class="bouton" type="button" value="Echanger mes ressources"></a>

        <%-- //Cadran Durées de vie--%>
        <div class="dureeVie">
            Durées de vie
            <br>
            <table>
                <tr>
                    <td>
                        <img src="Images/farmer.png" alt=""/>
                    </td>
                    <c:if test="${dureeVieChevre != null}">
                        <td>
                            <img src="Images/chevre.png" alt=""/>
                        </td>
                    </c:if>
                </tr>
                <tr>
                    <td>${dureeVieFermier}</td>
                    <c:if test="${dureeVieChevre != null}">
                        <td>${dureeVieChevre}</td>
                    </c:if>
                </tr>
            </table>
            <a href="nourrir_servlet"><input class="bouton" type="button" value="Nourrir mes ressources"></a>
        </div>

        <%-- //Cadran stock ressources--%>
        <table class="stock">
            <tr>
                <td>
                    <img src="Images/Carotte.png" alt=""/>
                </td>
                <td>
                    <table>
                        <tr>
                            <td>${nbCarottesDispo} disponible(s) <a href="la_ferme_servlet?typeRessource=carotte"><input class="boutonStock" type="button" value="Planter"></a></td>
                        </tr>
                        <tr>
                            <td>${nbCarottesPantees} plant&eacute;e(s)</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="Images/ble.png" alt=""/>
                </td>
                <td>
                    <table>
                        <tr>
                            <td>${nbBlesDispo} disponible(s) <a href="la_ferme_servlet?typeRessource=ble"><input class="boutonStock" type="button" value="Planter"></a></td>
                        </tr>
                        <tr>
                            <td>${nbBlesPantees} plant&eacute;e(s)</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="Images/chevre.png" alt=""/>
                </td>
                <td>
                    <table style="width: 100">
                        <tr>
                            <td>${nbChevresDispo} disponible(s) <a href="la_ferme_servlet?typeRessource=chevre"><input class="boutonStock" type="button" value="Reproduction"></a></td>
                        </tr>
                        <tr>
                            <td>${nbChevresEnceintes} enceinte(s)</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="Images/fromage2.png" alt=""/>
                </td>
                <td>
                    ${nbFromagesDispo}
                </td>
            </tr> 
    </table>


    <c:import url="_PIED.jsp"/>
</body>
</html>

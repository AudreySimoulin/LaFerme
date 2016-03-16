<%-- 
    Document   : la_ferme
    Created on : 16 mars 2016, 14:41:44
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        //Cadran Date Jeu
        <div class="dateJeu">             
            <img src="Images/calendar.png" alt=""/> ${dateJeu}
        </div>

        //Bouton Echanger ressource
        <a href="echanger_ressource_servlet"><input class="bouton" type="button" value="Echanger mes ressources"></a>

        //Cadran Durées de vie
        <div class="dureeVie">
            Durées de vie
            <br>
            <table>
                <tr>
                    <td>
                        <img src="Images/Farmer_Smurf.png" alt=""/>
                    </td>
                    <td>
                        <img src="Images/chevre.png" alt=""/>
                    </td>
                </tr>
                <tr>
                    <td>${dureeVieFermier}</td>
                    <td>${dureeVieChevre}</td>
                </tr>
            </table>
            <a href="nourrir_servlet"><input class="bouton" type="button" value="Nourrir mes ressources"></a>
        </div>

        //Cadran stock ressources
        <table class="stock">
            <tr>
                <td>
                    <img src="Images/Carotte.png" alt=""/>
                </td>
                <td>
                    <table>
                        <tr>
                            <td>${nbCarottesDispo} disponible(s) <a href=""><input class="boutonStock" type="button" value="Planter"></a></td>
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
                            <td>${nbBlesDispo} disponible(s) <a href=""><input class="boutonStock" type="button" value="Planter"></a></td>
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
                    <table>
                        <tr>
                            <td>${nbChevresDispo} disponible(s) <a href=""><input class="boutonStock" type="button" value="Reproduction"></a></td>
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



    </body>
</html>

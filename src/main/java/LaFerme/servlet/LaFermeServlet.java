/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.servlet;

import LaFerme.entity.Utilisateur;
import LaFerme.enumeration.StatutRessource;
import LaFerme.enumeration.TypeRessource;
import LaFerme.service.DateService;
import LaFerme.service.RessourceService;
import LaFerme.service.UtilisateurService;
import LaFerme.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "LaFermeServlet", urlPatterns = {"/la_ferme_servlet"})
public class LaFermeServlet extends AutowireServlet {

    @Autowired
    private DateService dateService;
    @Autowired
    private RessourceService ressourceService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dateJeu", dateService.getHorloge());

        Utilisateur utilisateur = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));

        req.setAttribute("nbCarottesDispo", ressourceService.countByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.carotte, StatutRessource.disponible, utilisateur));
        req.setAttribute("nbCarottesPantees", ressourceService.countByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.carotte, StatutRessource.occupe, utilisateur));
        req.setAttribute("nbBlesDispo", ressourceService.countByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.ble, StatutRessource.disponible, utilisateur));
        req.setAttribute("nbBlesPantees", ressourceService.countByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.ble, StatutRessource.occupe, utilisateur));
        req.setAttribute("nbChevresDispo", ressourceService.countByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.chevre, StatutRessource.disponible, utilisateur));
        req.setAttribute("nbChevresEnceintes", (ressourceService.countByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.chevre, StatutRessource.occupe, utilisateur)) / 2);
        req.setAttribute("nbFromagesDispo", ressourceService.countByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.chevre, StatutRessource.disponible, utilisateur));

        try {
            String dureeVieFermier = dateService.getDureeVie(TypeRessource.fermier, utilisateur);
            req.setAttribute("dureeVieFermier", dureeVieFermier);
        } catch (Exception e) {

        }

            try {
                String dureeVieChevre = dateService.getDureeVie(TypeRessource.chevre, utilisateur);
                req.setAttribute("dureeVieChevre", dureeVieChevre);
            } catch (Exception ex) {

            }

            req.getRequestDispatcher("la_ferme.jsp").forward(req, resp);

        }

    }


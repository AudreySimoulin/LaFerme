/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.servlet;

import LaFerme.entity.Ressource;
import LaFerme.entity.Utilisateur;
import LaFerme.enumeration.StatutRessource;
import LaFerme.enumeration.TypeRessource;
import LaFerme.service.NourrirService;
import LaFerme.service.RessourceService;
import LaFerme.service.UtilisateurService;
import LaFerme.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "NourrirServlet", urlPatterns = {"/nourrir_servlet"})
public class NourrirServlet extends AutowireServlet {

    @Autowired
    private NourrirService nourrirService;
    @Autowired
    private RessourceService ressourceService;
    @Autowired
    private UtilisateurService utilisateurService;

    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));
        Ressource boucheAnourrir = ressourceService.findOne(Long.parseLong(req.getParameter("boucheAnourrir")));
        Ressource nourriture = ressourceService.findOne(Long.parseLong(req.getParameter("nourriture")));
        nourrirService.nourrir(utilisateur, boucheAnourrir, nourriture);
        resp.sendRedirect("afficher_nourrir_servlet");
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.servlet;

import LaFerme.entity.Utilisateur;
import LaFerme.enumeration.StatutRessource;
import LaFerme.enumeration.TypeRessource;
import LaFerme.service.ReproductionService;
import LaFerme.service.RessourceService;
import LaFerme.service.UtilisateurService;
import LaFerme.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ReproductionServlet", urlPatterns = {"/reproduction_servlet"})
public class ReproductionServlet extends AutowireServlet {
    @Autowired
    private ReproductionService reproductionService;
    @Autowired
    private RessourceService ressourceService;
    
    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TypeRessource typeRessource = TypeRessource.valueOf(TypeRessource.class, req.getParameter("typeRessource"));
        Utilisateur utilisateur = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));
        reproductionService.reproduire(ressourceService.findByTypeRessourceAndStatutRessourceAndUtilisateur(typeRessource, StatutRessource.disponible, utilisateur).get(0));
        resp.sendRedirect("la_ferme_servlet");
        
    }
    

}

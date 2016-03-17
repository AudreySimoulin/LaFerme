/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.servlet;

import LaFerme.entity.Ressource;
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
@WebServlet(name = "AfficherNourrirServlet", urlPatterns = {"/afficher_nourrir_servlet"})
public class AfficherNourrirServlet extends AutowireServlet {    
    
    @Autowired
    private RessourceService ressourceService;
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ressource> nourritures = ressourceService.findDistinctTypeRessourceByStatutRessource(StatutRessource.disponible);
        List<Ressource> bouchesAnourrir = ressourceService.findByTypeRessource(TypeRessource.fermier);
        for(Ressource r : ressourceService.findByTypeRessource(TypeRessource.chevre)){
            bouchesAnourrir.add(r);
        }
        req.setAttribute("nourritures", nourritures);
        req.setAttribute("bouchesAnourrir", bouchesAnourrir);
        req.getRequestDispatcher("nourrir.jsp").forward(req, resp);
    }

}

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
import java.util.ArrayList;
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
    @Autowired
    private UtilisateurService utilisateurService;
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = utilisateurService.findOneByLogin(((String) req.getSession().getAttribute("login")));
        List<Ressource> nourrituresFermier = new ArrayList<>();
        List<Ressource> nourrituresChevre = new ArrayList<>();
        
        List<Ressource> carottes = ressourceService.findByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.carotte, StatutRessource.disponible,utilisateur);
        List<Ressource> bles = ressourceService.findByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.ble, StatutRessource.disponible, utilisateur);
        List<Ressource> fromages = ressourceService.findByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.fromage, StatutRessource.disponible,utilisateur);
        List<Ressource> chevres = ressourceService.findByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.chevre, StatutRessource.disponible,utilisateur);
        
        if(!carottes.isEmpty()){
          nourrituresFermier.add(carottes.get(0));
          nourrituresChevre.add(carottes.get(0));          
        }
        if(!bles.isEmpty()){
          nourrituresFermier.add(bles.get(0));
          nourrituresChevre.add(bles.get(0));
        }
        if(!fromages.isEmpty()){
          nourrituresFermier.add(fromages.get(0));
        }
        if(!chevres.isEmpty()){
          nourrituresFermier.add(chevres.get(0));
        }        
        
        List<Ressource> bouchesAnourrir = ressourceService.findByTypeRessourceAndUtilisateur(TypeRessource.fermier,utilisateur);
        for(Ressource r : ressourceService.findByTypeRessourceAndUtilisateur(TypeRessource.chevre, utilisateur)){
            bouchesAnourrir.add(r);
        }       
        
        
        req.setAttribute("nourrituresChevre", nourrituresChevre);
        req.setAttribute("nourrituresFermier", nourrituresFermier);
        req.setAttribute("bouchesAnourrir", bouchesAnourrir);
        req.getRequestDispatcher("nourrir.jsp").forward(req, resp);
        
    }

}

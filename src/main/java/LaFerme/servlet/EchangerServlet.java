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
import LaFerme.service.DateService;
import LaFerme.service.EchangerService;
import LaFerme.service.RessourceService;
import LaFerme.service.UtilisateurService;
import LaFerme.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "EchangerServlet", urlPatterns = {"/echanger_servlet"})
public class EchangerServlet extends AutowireServlet {
    
    @Autowired
    private EchangerService echangerService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private RessourceService ressourceService;
    
    @Autowired
    private DateService dateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = utilisateurService.findOneByLogin(((String) req.getSession().getAttribute("login")));
        
        List<Ressource> ressourcesAvendre = new ArrayList<>();
        List<Ressource> carottes = ressourceService.findByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.carotte, StatutRessource.disponible,utilisateur);
        List<Ressource> bles = ressourceService.findByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.ble, StatutRessource.disponible, utilisateur);
        List<Ressource> chevres = ressourceService.findByTypeRessourceAndStatutRessourceAndUtilisateur(TypeRessource.chevre, StatutRessource.disponible,utilisateur);
        
        if(!carottes.isEmpty()){
          ressourcesAvendre.add(carottes.get(0));
        }
        if(!bles.isEmpty()){
          ressourcesAvendre.add(bles.get(0));
        }
        if(!chevres.isEmpty()){
          ressourcesAvendre.add(chevres.get(0));
        }
        
        req.setAttribute("ressourcesAvendre", ressourcesAvendre);
        
        List<TypeRessource> typeRessourcesAacheter = new ArrayList<>();
        
        TypeRessource carotte = TypeRessource.valueOf("carotte");
        TypeRessource ble = TypeRessource.valueOf("ble");
        TypeRessource chevre = TypeRessource.valueOf("chevre");
        
        typeRessourcesAacheter.add(ble);
        typeRessourcesAacheter.add(carotte);
        typeRessourcesAacheter.add(chevre);
        
        req.setAttribute("typeRessourcesAacheter", typeRessourcesAacheter);
        
        req.getRequestDispatcher("echanger.jsp").forward(req, resp);

        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));
        Ressource ressourceAvendre = ressourceService.findOne(Long.parseLong(req.getParameter("ressourceAvendre")));        
        TypeRessource typeRessource = TypeRessource.valueOf(req.getParameter("typeRessourceAacheter"));
        
        echangerService.echanger(utilisateur, ressourceAvendre.getTypeRessource(), typeRessource);
        
        resp.sendRedirect("la_ferme_servlet");
    }
    
    
    
    
    

}

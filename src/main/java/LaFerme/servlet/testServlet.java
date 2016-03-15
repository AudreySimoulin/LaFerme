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
import LaFerme.service.RessourceService;
import LaFerme.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "testServlet", urlPatterns = {"/testServlet"})
public class testServlet extends AutowireServlet {
    
    @Autowired
    private RessourceService ressourceService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ressource carotte1 = new Ressource(TypeRessource.carotte, StatutRessource.disponible, new Date());
        Ressource carotte2 = new Ressource(TypeRessource.carotte, StatutRessource.disponible, new Date());
        Ressource carotte3 = new Ressource(TypeRessource.carotte, StatutRessource.disponible, new Date());
        Ressource ble1 = new Ressource(TypeRessource.ble, StatutRessource.disponible, new Date());
        Ressource ble2 = new Ressource(TypeRessource.ble, StatutRessource.disponible, new Date());
        Ressource chevre = new Ressource(TypeRessource.chevre, StatutRessource.disponible, new Date());
        
        ressourceService.save(carotte1);
        ressourceService.save(carotte2);
        ressourceService.save(carotte3);
        ressourceService.save(ble1);
        ressourceService.save(ble2);
        ressourceService.save(chevre);
        
        System.out.println("**************" + ressourceService.findByTypeRessourceAndStatutRessource(TypeRessource.carotte, StatutRessource.disponible).size());
    }
    
    

}

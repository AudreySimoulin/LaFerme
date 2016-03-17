/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.servlet;

import LaFerme.enumeration.StatutRessource;
import LaFerme.enumeration.TypeRessource;
import LaFerme.service.DateService;
import LaFerme.service.RessourceService;
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
public class LaFermeServlet extends AutowireServlet{
    
    @Autowired
    private DateService dateService;
    @Autowired
    private RessourceService ressourceService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dateJeu", dateService.getDateJeu());
        req.setAttribute("nbCarottesDispo", ressourceService.countByTypeRessourceAndStatutRessource(TypeRessource.carotte, StatutRessource.disponible));
        req.setAttribute("nbCarottesPantees", ressourceService.countByTypeRessourceAndStatutRessource(TypeRessource.carotte, StatutRessource.occupe));
        req.setAttribute("nbBlesDispo", ressourceService.countByTypeRessourceAndStatutRessource(TypeRessource.ble, StatutRessource.disponible));
        req.setAttribute("nbBlesPantees", ressourceService.countByTypeRessourceAndStatutRessource(TypeRessource.ble, StatutRessource.occupe));
        req.setAttribute("nbChevresDispo", ressourceService.countByTypeRessourceAndStatutRessource(TypeRessource.chevre, StatutRessource.disponible));
        req.setAttribute("nbChevresEnceintes", (ressourceService.countByTypeRessourceAndStatutRessource(TypeRessource.chevre, StatutRessource.occupe))/2);
        req.setAttribute("nbFromagesDispo", ressourceService.countByTypeRessourceAndStatutRessource(TypeRessource.chevre, StatutRessource.disponible));
        
         
        Date finDeCycleFermier = ressourceService.findByTypeRessourceOrderByDateFinCycle(TypeRessource.fermier).get(0).getDateFinCycle();
        Long dureeVieFermier = finDeCycleFermier.getTime()-dateService.getDateJeu().getTime().getTime();
        req.setAttribute("dureeVieFermier", dureeVieFermier);
         
        if(!ressourceService.findByTypeRessource(TypeRessource.chevre).isEmpty()){
        Date finDeCycleChevre = ressourceService.findByTypeRessourceOrderByDateFinCycle(TypeRessource.chevre).get(0).getDateFinCycle();
        Long dureeVieChevre = finDeCycleChevre.getTime()-dateService.getDateJeu().getTime().getTime();
        req.setAttribute("dureeVieChevre", dureeVieChevre);
        }
        
        req.getRequestDispatcher("la_ferme.jsp").forward(req, resp);
        
    }
    
    

}

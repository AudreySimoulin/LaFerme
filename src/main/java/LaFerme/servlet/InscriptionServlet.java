/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.servlet;

import LaFerme.entity.Utilisateur;
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
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription_servlet"})
public class InscriptionServlet extends AutowireServlet {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        
        if(utilisateurService.findOneByLoginAndPassword(login, password) != null){
            throw new RuntimeException("Login déjà existant");
        }
        
        Utilisateur utilisateur = new Utilisateur(login, password);
        utilisateurService.save(utilisateur);
        
        resp.sendRedirect("connexion.jsp");
        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import LaFerme.entity.Utilisateur;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class DateService {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private MourirService mourirService;    
    @Autowired
    private ReproductionService reproductionService;

    private GregorianCalendar dateJeu;

    public DateService() {
        dateJeu = new GregorianCalendar();
    }

    public boolean dateExpiree(Date date) {
        return dateJeu.after(date) ;
          
    }

    public Date calculDateFuture(int nbMois) {
        dateJeu.add(Calendar.MONTH, nbMois);
        Date dateFutur = dateJeu.getTime();          
        return dateFutur;
    }    
    
    @Scheduled(fixedDelay = 60000)
    public void accelereDateJeu(){
        dateJeu.add(Calendar.HOUR, 1);
    }
    
    @Scheduled (fixedDelay = 60000)
    public void actualiserRessource(){
        for(Utilisateur u : utilisateurService.findAll()){
            reproductionService.naissance(u);
            mourirService.mourir(u);
        }
    }
    
    @Scheduled (fixedDelay = (6*30*24*60000))
    public void actualiserFromage(){
        for(Utilisateur u : utilisateurService.findAll()){
            reproductionService.genererFromage(u);
        }
    }
    
    

    
}

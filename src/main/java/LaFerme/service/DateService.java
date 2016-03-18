/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import LaFerme.entity.Ressource;
import LaFerme.entity.Utilisateur;
import LaFerme.enumeration.TypeRessource;
import java.text.SimpleDateFormat;
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
    @Autowired
    private RessourceService ressourceService;

    private GregorianCalendar dateJeu;
    

    public GregorianCalendar getDateJeu() {
        return dateJeu;
    }
    

    public DateService() {
        dateJeu = new GregorianCalendar();
    }

    public boolean dateExpiree(Date date) {
        
        System.out.format("*** Date jour: %s Date en param: %s\n", dateJeu, date);
        
        return dateJeu.getTime().after(date) ;
          
    }

    public Date calculDateFuture(int nbMinutes) {
        Calendar c = new GregorianCalendar();
        c.setTime(dateJeu.getTime());
        c.add(Calendar.MINUTE, nbMinutes);
        Date dateFutur = c.getTime();          
        return dateFutur;
    }    
    
//    @Scheduled(fixedDelay = 60000)
//    public void accelereDateJeu(){
//        dateJeu.add(Calendar.HOUR, 1);
//    }
    
    @Scheduled (fixedDelay = 6000)
    public void actualiserRessource(){
        System.out.println("***");
//        for(Utilisateur u : utilisateurService.findAll()){
            reproductionService.naissance();
            mourirService.mourir();
//        }
    }
    
    @Scheduled (fixedDelay = 360000)
    public void actualiserFromage(){
        for(Utilisateur u : utilisateurService.findAll()){
            reproductionService.genererFromage(u);
        }
    }
    
    public String getHorloge(){        
        SimpleDateFormat horlogeFormat = new SimpleDateFormat("hh:mm' 'dd/MM/YYYY");
        String horloge = horlogeFormat.format(dateJeu.getTime());        
        return horloge;
        
    }
    
    public String getDureeVie(TypeRessource typeRessource, Utilisateur utilisateur){
        Ressource ressource = ressourceService.findByTypeRessourceAndUtilisateurOrderByDateFinCycle(typeRessource, utilisateur).get(0);
        Long dureeVieMs = ressource.getDateFinCycle().getTime()-dateJeu.getTime().getTime();
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(dureeVieMs);
        SimpleDateFormat horlogeFormat = new SimpleDateFormat("mm:ss");
        String horloge = horlogeFormat.format(c.getTime());        
        return horloge;
    }
    
   
    
    

    
}

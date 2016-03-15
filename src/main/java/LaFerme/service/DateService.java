/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class DateService {

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
    
    public GregorianCalendar getDateJeu() {
        return dateJeu;
    }
    
    @Scheduled(fixedDelay = 60000)
    public void accelereDateJeu(){
        dateJeu.add(Calendar.HOUR, 1);
    }

    
}

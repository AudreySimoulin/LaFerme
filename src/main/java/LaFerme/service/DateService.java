/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class DateService {

    private static Date dateJeu;

    public DateService() {
        dateJeu = new Date();
    }

    public boolean dateExpiree(Date date){
        return true;
    }
    
    public Date calculDateFuture(int nbMois){
        return new Date();
    }

    public static Date getDateJeu() {
        return dateJeu;
    }
    
    
       

}

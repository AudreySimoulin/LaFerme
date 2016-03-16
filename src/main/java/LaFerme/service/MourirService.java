/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import LaFerme.entity.Ressource;
import LaFerme.enumeration.TypeRessource;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class MourirService {
    
    @Autowired
    private RessourceService ressourceService;
    
    @Autowired
    private DateService dateService;
    
    public void mourir(){
        for(Ressource ressource : ressourceService.findAll()){
            if(dateService.dateExpiree(ressource.getDateFinCycle()) && (ressource.getTypeRessource().equals(TypeRessource.chevre) || ressource.getTypeRessource().equals(TypeRessource.fermier))){
                ressourceService.delete(ressource);
            }
        }
        
        
    }
    
}

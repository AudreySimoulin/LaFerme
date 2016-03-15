/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import LaFerme.enumeration.TypeRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class StockService {
    
    @Autowired
    private RessourceService ressourceService;
    
    public boolean verifStock(int nbRessource, TypeRessource typeRessource){
        if(typeRessource.equals(TypeRessource.ble)){
            return true;
        }
        return true;
    }
    
    public void majStock(int nbRessource, TypeRessource typeRessource){
        
    }
    
}

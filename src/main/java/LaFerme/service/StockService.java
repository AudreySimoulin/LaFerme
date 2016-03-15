/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import LaFerme.entity.Ressource;
import LaFerme.entity.Utilisateur;
import LaFerme.enumeration.StatutRessource;
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

    @Autowired
    private DateService dateService;

    public boolean stockDisponible(int nbRessource, TypeRessource typeRessource) {
        if (typeRessource.equals(TypeRessource.ble)) {
            if (ressourceService.findByTypeRessource(typeRessource.ble).size() >= nbRessource) {
                return true;
            }
            return false;
        }

        if (typeRessource.equals(TypeRessource.carotte)) {
            if (ressourceService.findByTypeRessource(typeRessource.carotte).size() >= nbRessource) {
                return true;
            }
            return false;
        }

        if (typeRessource.equals(TypeRessource.chevre)) {
            if (ressourceService.findByTypeRessource(typeRessource.chevre).size() >= nbRessource) {
                return true;
            }
            return false;
        }

        if (typeRessource.equals(TypeRessource.fromage)) {
            if (ressourceService.findByTypeRessource(typeRessource.fromage).size() >= nbRessource) {
                return true;
            }
            return false;
        }
        return false;
    }

   }

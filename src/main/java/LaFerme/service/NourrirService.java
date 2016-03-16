/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import LaFerme.entity.Ressource;
import LaFerme.entity.Utilisateur;
import LaFerme.enumeration.TypeRessource;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class NourrirService {

    @Autowired
    private StockService stockService;
    @Autowired
    private DateService dateService;
    @Autowired
    private RessourceService ressourceService;

    public void nourrir(Utilisateur utilisateur, Ressource boucheAnourrir, Ressource nourriture) {
        //Nourir une chèvre
        if (boucheAnourrir.getTypeRessource().equals(TypeRessource.chevre)) {
            //Vérifier que la nouriture soit du blé ou des carottes
            if ((nourriture.getTypeRessource().equals(TypeRessource.ble)) || (nourriture.getTypeRessource().equals(TypeRessource.carotte))) {
                //Vérifier le stock
                if (stockService.stockDisponible(1, nourriture.getTypeRessource()) == true) {
                    //Mise à jour de la dateCycle
                    Date dateCycle = dateService.calculDateFuture(3);
                    boucheAnourrir.setDateFinCycle(dateCycle);
                    //Mise à jour du stock 
                    ressourceService.removeByUtilisateurIdAndTypeRessource(utilisateur.getId(), nourriture.getTypeRessource());
                }
                throw new RuntimeException("Pas assez de " + nourriture.getTypeRessource() + " en stock");
            }
            throw new RuntimeException(boucheAnourrir.getTypeRessource() + " ne mange pas ce type de nourriture");
        }
        //Nourrrir fermier
        if (boucheAnourrir.getTypeRessource().equals(TypeRessource.fermier)) {
            //Vérifier le stock en fonction de la nourriture
            if (nourriture.getTypeRessource().equals(TypeRessource.ble)) {
                if (stockService.stockDisponible(3, nourriture.getTypeRessource()) == true) {
                    //Mise à jour de la dateCycle
                    Date dateCycle = dateService.calculDateFuture(3);
                    boucheAnourrir.setDateFinCycle(dateCycle);
                    //Mise à jour du stock 
                    ressourceService.removeByUtilisateurIdAndTypeRessource(utilisateur.getId(), nourriture.getTypeRessource());
                }
                throw new RuntimeException("Pas assez de " + nourriture.getTypeRessource() + " en stock");
            }
            if (nourriture.getTypeRessource().equals(TypeRessource.carotte)) {
                if (stockService.stockDisponible(2, nourriture.getTypeRessource()) == true) {
                    //Mise à jour de la dateCycle
                    Date dateCycle = dateService.calculDateFuture(3);
                    boucheAnourrir.setDateFinCycle(dateCycle);
                    //Mise à jour du stock 
                    ressourceService.removeByUtilisateurIdAndTypeRessource(utilisateur.getId(), nourriture.getTypeRessource());
                }
                throw new RuntimeException("Pas assez de " + nourriture.getTypeRessource() + " en stock");
            }
            if (nourriture.getTypeRessource().equals(TypeRessource.fromage)) {
                if (stockService.stockDisponible(2, nourriture.getTypeRessource()) == true) {
                    //Mise à jour de la dateCycle
                    Date dateCycle = dateService.calculDateFuture(3);
                    boucheAnourrir.setDateFinCycle(dateCycle);
                    //Mise à jour du stock 
                    ressourceService.removeByUtilisateurIdAndTypeRessource(utilisateur.getId(), nourriture.getTypeRessource());
                }
                throw new RuntimeException("Pas assez de " + nourriture.getTypeRessource() + " en stock");
            }
            if (nourriture.getTypeRessource().equals(TypeRessource.chevre)) {
                if (stockService.stockDisponible(1, nourriture.getTypeRessource()) == true) {
                    //Mise à jour de la dateCycle
                    Date dateCycle = dateService.calculDateFuture(3);
                    boucheAnourrir.setDateFinCycle(dateCycle);
                    //Mise à jour du stock 
                    ressourceService.removeByUtilisateurIdAndTypeRessource(utilisateur.getId(), nourriture.getTypeRessource());
                }
                throw new RuntimeException("Pas assez de " + nourriture.getTypeRessource() + " en stock");
            }

        }
    }

}

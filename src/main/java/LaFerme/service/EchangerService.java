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
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class EchangerService {

    @Autowired
    private StockService stockService;
    @Autowired
    private RessourceService ressourceService;
    @Autowired
    private DateService dateService;

    public void echanger(Utilisateur utilisateur, Ressource ressourceVendue, Ressource ressourceAchetee) {
        //Initialisation de la valeur de chaque type de ressource
        Map<TypeRessource, Integer> mapValeur = new HashMap();
        mapValeur.put(TypeRessource.ble, 1);
        mapValeur.put(TypeRessource.carotte, 2);
        mapValeur.put(TypeRessource.chevre, 1);

        //Initialisation des valeur de vente et d'achat
        int valeurVente = mapValeur.get(ressourceVendue.getTypeRessource());
        int valeurAchat = mapValeur.get(ressourceAchetee.getTypeRessource());

        //Calcul du nombre de ressources achatées et vendues        
        int nbAchetee = valeurVente / valeurAchat;
        int nbVendue = 1;

        if (nbAchetee < 1) {
            nbVendue = valeurAchat / valeurVente;
            nbAchetee = 1;
        }

        //Vérification du stock
        if (stockService.stockDisponible(nbVendue, ressourceVendue.getTypeRessource()) == true) {
            //Mise à jour du stock            
            for (int i = 0; i <= nbAchetee; i++) {
                Ressource achat = new Ressource(ressourceAchetee.getTypeRessource(), StatutRessource.disponible, dateService.calculDateFuture(3), utilisateur);
                utilisateur.getRessources().add(achat);
                ressourceService.save(achat);
            }
            for (int i = 0; i <= nbVendue; i++) {
                ressourceService.delete(ressourceVendue);
            }

        }
    }

}

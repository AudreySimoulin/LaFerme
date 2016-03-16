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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ReproductionService {

    @Autowired
    private StockService stockService;

    @Autowired
    private RessourceService ressourceService;

    @Autowired
    private DateService dateService;
    
    @Autowired
    private UtilisateurService utilisateurService;

    public void reproduire(Ressource ressource) {
        //plantation
        if (ressource.getTypeRessource().equals(TypeRessource.ble) || ressource.getTypeRessource().equals(TypeRessource.carotte)) {
            if (stockService.stockDisponible(1, ressource.getTypeRessource())) {
                ressource.setStatutRessource(StatutRessource.occupe);
                ressource.setDateFinOccupation(dateService.calculDateFuture(6));
            }
            throw new RuntimeException("Stock insuffisant");
        }

        //accouplement
        if (ressource.getTypeRessource().equals(TypeRessource.chevre)) {
            if (stockService.stockDisponible(2, TypeRessource.chevre)) {
                ressource.setStatutRessource(StatutRessource.occupe);
                ressource.setDateFinOccupation(dateService.calculDateFuture(12));
            }
            throw new RuntimeException("Stock insuffisant");
        }
    }

    public void naissance(Utilisateur utilisateur) {
        int lower = 0;
        int higher = 0;
        
        for(Ressource ressource : ressourceService.findByStatutRessource(StatutRessource.occupe)){
        if (ressource.getTypeRessource().equals(TypeRessource.carotte) && dateService.dateExpiree(ressource.getDateFinOccupation())) {
            lower = 2;
            higher = 4;
            ressourceService.removeByUtilisateurIdAndTypeRessource(utilisateur.getId(), ressource.getTypeRessource());
        }
        if (ressource.getTypeRessource().equals(TypeRessource.ble) && dateService.dateExpiree(ressource.getDateFinOccupation())) {
            lower = 3;
            higher = 5;
            ressourceService.removeByUtilisateurIdAndTypeRessource(utilisateur.getId(), ressource.getTypeRessource());
        }
        if (ressource.getTypeRessource().equals(TypeRessource.chevre) && dateService.dateExpiree(ressource.getDateFinOccupation())) {
            lower = 1;
            higher = 2;
            ressource.setStatutRessource(StatutRessource.disponible);
        }
        int nbNaissance = (int) (Math.random() * (higher - lower)) + lower;
        for(int i = 0; i<=nbNaissance; i++){
            Ressource r = new Ressource(ressource.getTypeRessource(), StatutRessource.disponible, dateService.calculDateFuture(3), utilisateur);
            utilisateur.getRessources().add(r);
            ressourceService.save(r);
            utilisateurService.save(utilisateur);
        }
        }
    }
    
    @Scheduled
    public void genererFromage(Utilisateur utilisateur){
        int lower = 0;
        int higher = 0;
        for(Ressource ressource : ressourceService.findByTypeRessource(TypeRessource.chevre)){
            lower = 2;
            higher = 4;
            int nbFromage = (int) (Math.random() * (higher - lower)) + lower;
            
            for(int i = 0; i<=nbFromage; i++){
                Ressource r = new Ressource(TypeRessource.fromage, StatutRessource.disponible, utilisateur);
                utilisateur.getRessources().add(r);
                ressourceService.save(r);
                utilisateurService.save(utilisateur);
            }
        }
    }
}

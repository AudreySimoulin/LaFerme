/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import LaFerme.entity.Ressource;
import LaFerme.enumeration.StatutRessource;
import LaFerme.enumeration.TypeRessource;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface RessourceService extends CrudRepository<Ressource, Long>{   
    public List<Ressource> findByTypeRessourceAndStatutRessource(TypeRessource typeRessource, StatutRessource statutRessource);
    public List<Ressource> findByStatutRessource(StatutRessource statutRessource);
    public void removeByUtilisateurIdAndTypeRessource(Long idUtilisateur, TypeRessource typeRessource);
    public List<Ressource> findByTypeRessource(TypeRessource typeRessource);
    public Long countByTypeRessourceAndStatutRessource(TypeRessource typeRessource, StatutRessource statutRessource);    
    public List<Ressource> findByTypeRessourceOrderByDateFinCycle(TypeRessource typeRessource);
    public List<Ressource> findDistinctTypeRessourceByStatutRessource(StatutRessource statutRessource);    
    public List<Ressource> findByTypeRessourceDistinctNotInAndStatutRessource(TypeRessource typeRessource, StatutRessource statutRessource);
    
}

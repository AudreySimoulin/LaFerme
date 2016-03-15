/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.service;

import LaFerme.entity.Ressource;
import LaFerme.enumeration.TypeRessource;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface RessourceService extends CrudRepository<Ressource, Long>{
    public List<Ressource> findByTypeRessource(TypeRessource typeRessource);
    
}

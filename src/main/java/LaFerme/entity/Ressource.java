/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaFerme.entity;

import LaFerme.enumeration.StatutRessource;
import LaFerme.enumeration.TypeRessource;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Ressource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeRessource typeRessource;

    @Enumerated(EnumType.STRING)
    private StatutRessource statutRessource;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinCycle;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinOccupation;

    @ManyToOne
    @JoinColumn(name = "UTIL_ID")
    private Utilisateur utilisateur;

    public Ressource() {
    }

    public Ressource(TypeRessource typeRessource, StatutRessource statutRessource, Date dateCycle, Utilisateur utilisateur) {
        this.typeRessource = typeRessource;
        this.statutRessource = statutRessource;
        this.dateFinCycle = dateCycle;
        this.utilisateur = utilisateur;
    }

    public Ressource(TypeRessource typeRessource, StatutRessource statutRessource, Date dateCycle) {
        this.typeRessource = typeRessource;
        this.statutRessource = statutRessource;
        this.dateFinCycle = dateCycle;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public TypeRessource getTypeRessource() {
        return typeRessource;
    }

    public void setTypeRessource(TypeRessource typeRessource) {
        this.typeRessource = typeRessource;
    }

    public StatutRessource getStatutRessource() {
        return statutRessource;
    }

    public void setStatutRessource(StatutRessource statutRessource) {
        this.statutRessource = statutRessource;
    }

    public Date getDateFinCycle() {
        return dateFinCycle;
    }

    public void setDateFinCycle(Date dateFinCycle) {
        this.dateFinCycle = dateFinCycle;
    }

    public Date getDateFinOccupation() {
        return dateFinOccupation;
    }

    public void setDateFinOccupation(Date dateFinOccupation) {
        this.dateFinOccupation = dateFinOccupation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ressource)) {
            return false;
        }
        Ressource other = (Ressource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LaFerme.entity.Ressources[ id=" + id + " ]";
    }

}

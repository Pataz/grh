/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author Ordinateur
 */
@Entity
public class Absence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Version
    private Timestamp version;
    @ManyToOne
    private Absence absence;
    @ManyToOne
    private Mois mois;
    @ManyToOne
    private ProgressionAgent progressionAgent;
    @Lob
    @Column(length = 500)
    private String observation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private String etat;
    private boolean deduitConge;
    private boolean deduitSalaire;
    private String nbreHeure;

    public Absence() {
    }

    public Absence(Absence absence) {
    }

    @PrePersist
    public void initDateCreation() {
        dateCreation = new Date();
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Mois getMois() {
        return mois;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
    }

    public boolean isDeduitConge() {
        return deduitConge;
    }

    public void setDeduitConge(boolean deduitConge) {
        this.deduitConge = deduitConge;
    }

    public boolean isDeduitSalaire() {
        return deduitSalaire;
    }

    public void setDeduitSalaire(boolean deduitSalaire) {
        this.deduitSalaire = deduitSalaire;
    }

    public String getNbreHeure() {
        return nbreHeure;
    }

    public void setNbreHeure(String nbreHeure) {
        this.nbreHeure = nbreHeure;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public ProgressionAgent getProgressionAgent() {
        return progressionAgent;
    }

    public void setProgressionAgent(ProgressionAgent progressionAgent) {
        this.progressionAgent = progressionAgent;
    }

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the code fields are not set
        if (!(object instanceof Absence)) {
            return false;
        }
        Absence other = (Absence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}

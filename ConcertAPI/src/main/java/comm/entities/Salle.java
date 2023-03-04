package comm.entities;

import javax.persistence.*;

@Entity
@Table(name = "t_salle_sal")
public class Salle {
    @Id
    @Column(name = "sal_id")
    private Long salId;

    @Column(name = "sal_nom")
    private String salNom;

    @Column(name = "sal_adresse")
    private String salAdresse;

    @Column(name = "sal_capacite")
    private Integer salCapacite;

    @Column(name = "sal_nom_gestionnaire")
    private String salNomGestionnaire;

    @Column(name = "sal_prenom_gestionnaire")
    private String salPrenomGestionnaire;

    @Column(name = "sal_association")
    private String salAssociation;

    public Long getSalId() {
        return this.salId;
    }

    public void setSalId(Long salId) {
        this.salId = salId;
    }

    public String getSalNom() {
        return this.salNom;
    }

    public void setSalNom(String salNom) {
        this.salNom = salNom;
    }

    public String getSalAdresse() {
        return this.salAdresse;
    }

    public void setSalAdresse(String salAdresse) {
        this.salAdresse = salAdresse;
    }

    public Integer getSalCapacite() {
        return this.salCapacite;
    }

    public void setSalCapacite(Integer salCapacite) {
        this.salCapacite = salCapacite;
    }

    public String getSalNomGestionnaire() {
        return this.salNomGestionnaire;
    }

    public void setSalNomGestionnaire(String salNomGestionnaire) {
        this.salNomGestionnaire = salNomGestionnaire;
    }

    public String getSalPrenomGestionnaire() {
        return this.salPrenomGestionnaire;
    }

    public void setSalPrenomGestionnaire(String salPrenomGestionnaire) {
        this.salPrenomGestionnaire = salPrenomGestionnaire;
    }

    public String getSalAssociation() {
        return this.salAssociation;
    }

    public void setSalAssociation(String salAssociation) {
        this.salAssociation = salAssociation;
    }
}

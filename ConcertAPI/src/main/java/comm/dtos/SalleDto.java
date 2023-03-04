package comm.dtos;

import lombok.Data;

@Data
public class SalleDto {
    private Long salId;
    private String salNom;
    private String salAdresse;
    private Integer salCapacite;
    private String salNomGestionnaire;
    private String salPrenomGestionnaire;
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

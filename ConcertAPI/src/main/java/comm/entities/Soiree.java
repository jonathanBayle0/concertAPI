package comm.entities;

import javax.persistence.*;

@Entity
@Table(name = "t_soiree_soi")
public class Soiree {
    @Id
    @Column(name = "soi_id")
    private Long soiId;

    @Column(name = "soi_nom")
    private String soiNom;

    @Column(name = "soi_date_debut")
    private java.sql.Timestamp soiDateDebut;

    @Column(name = "soi_date_fin")
    private java.sql.Timestamp soiDateFin;

    @Column(name = "sal_id")
    private Long salId;

    @Column(name = "soi_prix")
    private Double soiPrix;

    public Long getSoiId() {
        return this.soiId;
    }

    public void setSoiId(Long soiId) {
        this.soiId = soiId;
    }

    public String getSoiNom() {
        return this.soiNom;
    }

    public void setSoiNom(String soiNom) {
        this.soiNom = soiNom;
    }

    public java.sql.Timestamp getSoiDateDebut() {
        return this.soiDateDebut;
    }

    public void setSoiDateDebut(java.sql.Timestamp soiDateDebut) {
        this.soiDateDebut = soiDateDebut;
    }

    public java.sql.Timestamp getSoiDateFin() {
        return this.soiDateFin;
    }

    public void setSoiDateFin(java.sql.Timestamp soiDateFin) {
        this.soiDateFin = soiDateFin;
    }

    public Long getSalId() {
        return this.salId;
    }

    public void setSalId(Long salId) {
        this.salId = salId;
    }

    public Double getSoiPrix() {
        return this.soiPrix;
    }

    public void setSoiPrix(Double soiPrix) {
        this.soiPrix = soiPrix;
    }
}

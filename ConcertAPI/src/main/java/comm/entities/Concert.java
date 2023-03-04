package comm.entities;

import javax.persistence.*;

@Entity
@Table(name = "t_concert_con")
public class Concert {
    @Id
    @Column(name = "con_id")
    private Long conId;

    @Column(name = "con_date_debut")
    private java.sql.Timestamp conDateDebut;

    @Column(name = "con_date_fin")
    private java.sql.Timestamp conDateFin;

    @Column(name = "soi_id")
    private Long soiId;

    @Column(name = "gro_id")
    private Long groId;


    public Long getConId() {
        return this.conId;
    }

    public void setConId(Long conId) {
        this.conId = conId;
    }

    public java.sql.Timestamp getConDateDebut() {
        return this.conDateDebut;
    }

    public void setConDateDebut(java.sql.Timestamp conDateDebut) {
        this.conDateDebut = conDateDebut;
    }

    public java.sql.Timestamp getConDateFin() {
        return this.conDateFin;
    }

    public void setConDateFin(java.sql.Timestamp conDateFin) {
        this.conDateFin = conDateFin;
    }

    public Long getSoiId() {
        return this.soiId;
    }

    public void setSoiId(Long soiId) {
        this.soiId = soiId;
    }

    public Long getGroId() {
        return this.groId;
    }

    public void setGroId(Long groId) {
        this.groId = groId;
    }
}

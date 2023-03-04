package comm.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SoireeDto {
    private Long soiId;
    private String soiNom;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.sql.Timestamp soiDateDebut;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.sql.Timestamp soiDateFin;
    private Long salId;
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

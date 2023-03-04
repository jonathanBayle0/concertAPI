package comm.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ConcertDto {
    private Long conId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.sql.Timestamp conDateDebut;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.sql.Timestamp conDateFin;
    private Long soiId;
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

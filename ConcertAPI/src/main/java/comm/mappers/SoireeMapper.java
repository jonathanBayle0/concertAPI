package comm.mappers;

import comm.dtos.SoireeDto;
import comm.entities.Soiree;
import org.springframework.stereotype.Service;

@Service
public class SoireeMapper {
    public SoireeDto soireeEntityToDto(Soiree soi) {
        SoireeDto soiDto = new SoireeDto();

        soiDto.setSoiId(soi.getSoiId());
        soiDto.setSoiNom(soi.getSoiNom());
        soiDto.setSoiDateDebut(soi.getSoiDateDebut());
        soiDto.setSoiDateFin(soi.getSoiDateFin());
        soiDto.setSoiPrix(soi.getSoiPrix());
        soiDto.setSalId(soi.getSalId());

        return soiDto;
    }

    public Soiree soireeDtoToEntity(SoireeDto soiDto) {
        Soiree soi = new Soiree();

        soi.setSoiId(soiDto.getSoiId());
        soi.setSoiNom(soiDto.getSoiNom());
        soi.setSoiDateDebut(soiDto.getSoiDateDebut());
        soi.setSoiDateFin(soiDto.getSoiDateFin());
        soi.setSoiPrix(soiDto.getSoiPrix());
        soi.setSalId(soiDto.getSalId());

        return soi;
    }
}

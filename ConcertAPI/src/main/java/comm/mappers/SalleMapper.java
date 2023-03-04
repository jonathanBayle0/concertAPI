package comm.mappers;

import comm.dtos.SalleDto;
import comm.entities.Salle;
import org.springframework.stereotype.Service;

@Service
public class SalleMapper {

    public SalleDto salleEntityToDto(Salle sal) {
        SalleDto salDto = new SalleDto();

        salDto.setSalId(sal.getSalId());
        salDto.setSalNom(sal.getSalNom());
        salDto.setSalAdresse(sal.getSalAdresse());
        salDto.setSalCapacite(sal.getSalCapacite());
        salDto.setSalNomGestionnaire(sal.getSalNomGestionnaire());
        salDto.setSalPrenomGestionnaire(sal.getSalPrenomGestionnaire());
        salDto.setSalAssociation(sal.getSalAssociation());

        return salDto;
    }

    public Salle salleDtoToEntity(SalleDto salDto) {
        Salle sal = new Salle();

        sal.setSalId(salDto.getSalId());
        sal.setSalNom(salDto.getSalNom());
        sal.setSalAdresse(salDto.getSalAdresse());
        sal.setSalCapacite(salDto.getSalCapacite());
        sal.setSalNomGestionnaire(salDto.getSalNomGestionnaire());
        sal.setSalPrenomGestionnaire(salDto.getSalPrenomGestionnaire());
        sal.setSalAssociation(salDto.getSalAssociation());

        return sal;
    }
}

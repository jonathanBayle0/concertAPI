package comm.mappers;

import comm.dtos.ConcertDto;
import comm.entities.Concert;
import org.springframework.stereotype.Service;

@Service
public class ConcertMapper {
    public ConcertDto concertEntityToDto(Concert con) {
        ConcertDto conDto = new ConcertDto();
        conDto.setConId(con.getConId());
        conDto.setConDateDebut(con.getConDateDebut());
        conDto.setConDateFin(con.getConDateFin());
        conDto.setGroId(con.getGroId());
        conDto.setSoiId(con.getSoiId());
        return conDto;
    }

    public Concert concertDtoToEntity(ConcertDto conDto) {
        Concert con = new Concert();
        con.setConId(conDto.getConId());
        con.setConDateDebut(conDto.getConDateDebut());
        con.setConDateFin(conDto.getConDateFin());
        con.setGroId(conDto.getGroId());
        con.setSoiId(conDto.getSoiId());
        return con;
    }
}

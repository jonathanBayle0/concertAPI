package comm.services;

import java.util.List;
import comm.dtos.ConcertDto;

public interface ConcertService {
    ConcertDto saveConcert(ConcertDto ConcertDto);

    ConcertDto getConcertById(Long ConcertId);

    boolean deleteConcert (Long ConcertId);

    List<ConcertDto> getAllConcerts();
}

package comm.services.impl;


import comm.dtos.ConcertDto;
import comm.dtos.GroupeDto;
import comm.dtos.SalleDto;
import comm.dtos.SoireeDto;
import comm.entities.Concert;
import comm.entities.Information;
import comm.mappers.ConcertMapper;
import comm.repositories.ConcertRepository;
import comm.repositories.InformationRepository;
import comm.services.ConcertService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("concertService")
public class ConcertServiceImpl implements ConcertService {

    private final ConcertRepository concertRepository;

    private final ConcertMapper concertMapper;

    private final SoireeServiceImpl soireeService;


    public ConcertServiceImpl(ConcertRepository concertRepository, ConcertMapper concertMapper, SoireeServiceImpl soireeService) {
        this.concertRepository = concertRepository;
        this.concertMapper = concertMapper;
        this.soireeService = soireeService;
    }

    @Override
    public ConcertDto saveConcert(ConcertDto concertDto) {
        // Verifier l'existence du groupe
        // if (! isGroupe(concertDto.getGroId())) throw new EntityNotFoundException("Groupe not found");
        // verification de l'existence de la soiree
        if ( ! isSoiree(concertDto.getSoiId())) throw new EntityNotFoundException("Soiree not found");
        // Verification si le concert est bien aux même horaires que la soiree
        if (isSoireeTimeConflict(concertDto)) throw new EntityNotFoundException("Le concert n'est pas dans le même créneau horaire que la soirée");

        // Verification des conflits avec les autres concerts
        if (isConcertConflict(concertDto)) throw new EntityExistsException("Concert déjà programmé à cette horaire");

        // Si aucun conflit, le concert est ajouter
        Concert concert = concertMapper.concertDtoToEntity(concertDto);
        concert = concertRepository.save(concert);
        return concertDto;
    }

    @Override
    public ConcertDto getConcertById(Long ConcertId) {

        Concert concert = concertRepository.findById(ConcertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return concertMapper.concertEntityToDto(concert);
    }

    /**
     * Renvoie l'ensemble des concerts associe a une soiree
     * @param soireeId
     * @return List<ConcertDto>
     */
    public List<ConcertDto> getAllConcertsFromSoiree(Long soireeId) {
        List<ConcertDto> allConcertDtos = this.getAllConcerts();
        List<ConcertDto> concerts = new ArrayList<>();
        for (ConcertDto c : allConcertDtos) {
            if (c.getSoiId() == soireeId) concerts.add(c);
        }
        return concerts;
    }

    /**
     * Renvoie l'ensemble des concerts associe a une salle
     * @param salleId salle dont on veut la liste des concerts
     * @return List<ConcertDto>
     */
    public List<ConcertDto> getAllConcertsFromSalle(Long salleId) {
        List<ConcertDto> allConcertDtos = this.getAllConcerts();
        List<ConcertDto> concerts = new ArrayList<>();
        for (ConcertDto c : allConcertDtos) {
            // On recupere la salle associe a la soiree
            SoireeDto s = soireeService.getSoireeById(c.getSoiId());
            if (s.getSalId() == salleId) concerts.add(c);
        }
        return concerts;
    }

    @Override
    public boolean deleteConcert(Long ConcertId) {
        concertRepository.deleteById(ConcertId);
        return true;
    }

    @Override
    public List<ConcertDto> getAllConcerts() {
        List<ConcertDto> concertDtos = new ArrayList<>();
        List<Concert> concerts = concertRepository.findAll();
        concerts.forEach(concert -> concertDtos.add(concertMapper.concertEntityToDto(concert)));
        return concertDtos;
    }

    public List<ConcertDto> getAllConcertsByGroupe(Long groupeId) {
        List<ConcertDto> AllconcertDtos = this.getAllConcerts();
        List<ConcertDto> concertDtos = new ArrayList<>();
        AllconcertDtos.forEach(concertDto -> {
            if(concertDto.getGroId() == groupeId)
                concertDtos.add(concertDto);
        });
        return concertDtos;
    }

    /**
     * Verification de l'existence d'une soiree
     * @param id de la soiree
     * @return true : la soiree existe, false sinon
     */
    private boolean isSoiree(Long id) {
        return soireeService.getSoireeById(id) != null;
    }

    /**
     * Verification des conflits d'horaires pour un même lieu et/ou un même groupe
     * @param concertDto : concert a ajouter
     * @return true si il y a un conflit, false sinon
     */
    private boolean isConcertConflict(ConcertDto concertDto) {
        // Vérification des conflits avec les autres concerts
        List<ConcertDto> concerts = this.getAllConcerts();
        for (ConcertDto c : concerts) {
            // S'ils ont la même soiree ou/et le même groupe, on vérifie les horaires
            if ((concertDto.getSoiId() == c.getSoiId() || concertDto.getGroId() == c.getGroId()) && concertDto.getConId() != c.getConId()) {
                if (concertDto.getConDateDebut().before(c.getConDateFin()) && concertDto.getConDateFin().after(c.getConDateDebut())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifie s'il y a un conflit entre les dates de la soiree et les date du concert
     * @param concertDto
     * @return true s'il y a un conflit, false sinon
     */
    private boolean isSoireeTimeConflict(ConcertDto concertDto) {
        SoireeDto soireeDto = soireeService.getSoireeById(concertDto.getSoiId());
        // Verification que la soiree commence avant le debut du concert et se termine apres la fin du concert
        if (soireeDto.getSoiDateDebut().before(concertDto.getConDateDebut()) && soireeDto.getSoiDateFin().after(concertDto.getConDateFin())) return false;
        return true;
    }

    /**
     * Verifie si le groupe existe ou non dans la base.
     * @param id du groupe.
     * @return true si le groupe existe, false sinon.
     */
    private boolean isGroupe (Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/groupes/"+id;
        return restTemplate.getForObject(url, GroupeDto.class) != null;
    }


}

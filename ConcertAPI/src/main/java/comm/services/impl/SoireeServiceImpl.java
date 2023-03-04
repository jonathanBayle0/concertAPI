package comm.services.impl;

import comm.dtos.ConcertDto;
import comm.dtos.SoireeDto;
import comm.entities.Soiree;
import comm.mappers.SoireeMapper;
import comm.repositories.SoireeRepository;
import comm.services.SoireeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("soireeService")
public class SoireeServiceImpl implements SoireeService {

    private final SoireeRepository soireeRepository;
    private final SoireeMapper soireeMapper;

    private final SalleServiceImpl salleService;


    public SoireeServiceImpl(SoireeRepository soireeRepository, SoireeMapper soireeMapper, SalleServiceImpl salleService) {
        this.soireeRepository = soireeRepository;
        this.soireeMapper = soireeMapper;
        this.salleService = salleService;
    }

    @Override
    public SoireeDto saveSoiree(SoireeDto soireeDto) {
        // verification de l'existence de la soiree
        if ( ! isSalle(soireeDto.getSalId())) throw new EntityNotFoundException("Salle not found");

        // Vérification des conflits avec les autres concerts
        if (isSalleConflict(soireeDto)) throw new EntityExistsException("Soiree déjà programmé à cette horaire dans cette salle");
        Soiree soiree = soireeMapper.soireeDtoToEntity(soireeDto);
        soiree = soireeRepository.save(soiree);
        return soireeMapper.soireeEntityToDto(soiree);
    }

    @Override
    public SoireeDto getSoireeById(Long SoireeId) {
        Soiree soiree = soireeRepository.findById(SoireeId).orElseThrow(() -> new EntityNotFoundException("Soiree not found"));
        return soireeMapper.soireeEntityToDto(soiree);
    }

    @Override
    public boolean deleteSoiree(Long SoireeId) {
        soireeRepository.deleteById(SoireeId);
        return true;
    }

    @Override
    public List<SoireeDto> getAllSoiree() {
        List<SoireeDto> soireeDtos = new ArrayList<>();
        List<Soiree> soirees = soireeRepository.findAll();
        soirees.forEach(soiree -> {
            soireeDtos.add(soireeMapper.soireeEntityToDto(soiree));
        });
        return soireeDtos;
    }

    /**
     * Verification de l'existence d'une salle
     * @param id de la salle
     * @return true : la salle existe, false sinon
     */
    private boolean isSalle(Long id) {
        return salleService.getSalleById(id) != null;
    }

    /**
     * Verification des conflits d'horaires pour une même salle
     * @param soireeDto : soiree a ajouter
     * @return true si il y a un conflit, false sinon
     */
    private boolean isSalleConflict(SoireeDto soireeDto) {
        // Vérification des conflits avec les autres soirees
        List<SoireeDto> soirees = this.getAllSoiree();
        for (SoireeDto s : soirees) {
            // S'ils ont la même salle, on vérifie les horaires
            if ((soireeDto.getSalId() == s.getSalId()) && soireeDto.getSoiId() != s.getSoiId()) {
                if (soireeDto.getSoiDateDebut().before(s.getSoiDateFin()) && soireeDto.getSoiDateFin().after(s.getSoiDateDebut())) {
                    return true;
                }
            }
        }

        return false;
    }
}

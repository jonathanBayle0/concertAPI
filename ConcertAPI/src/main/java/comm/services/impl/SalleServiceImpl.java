package comm.services.impl;

import comm.dtos.SalleDto;
import comm.entities.Information;
import comm.entities.Salle;
import comm.mappers.SalleMapper;
import comm.repositories.SalleRepository;
import comm.services.SalleService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("salleService")
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;
    private final SalleMapper salleMapper;

    public SalleServiceImpl(SalleRepository salleRepository, SalleMapper salleMapper) {
        this.salleRepository = salleRepository;
        this.salleMapper = salleMapper;
    }

    @Override
    public SalleDto saveSalle(SalleDto SalleDto) {
        Salle salle = salleMapper.salleDtoToEntity(SalleDto);
        salle = salleRepository.save(salle);
        return salleMapper.salleEntityToDto(salle);
    }

    @Override
    public SalleDto getSalleById(Long SalleId) {
        Salle salle = salleRepository.findById(SalleId).orElseThrow(() -> new EntityNotFoundException("Salle not found"));
        return salleMapper.salleEntityToDto(salle);
    }

    @Override
    public boolean deleteSalle(Long SalleId) {
        salleRepository.deleteById(SalleId);
        return true;
    }

    @Override
    public List<SalleDto> getAllSalles() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<Salle> salles = salleRepository.findAll();
        salles.forEach(salle -> salleDtos.add(salleMapper.salleEntityToDto(salle)));
        return salleDtos;
    }
}

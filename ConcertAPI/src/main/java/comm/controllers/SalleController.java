package comm.controllers;

import comm.dtos.ConcertDto;
import comm.dtos.SalleDto;
import comm.entities.Information;
import comm.services.impl.ConcertServiceImpl;
import comm.services.impl.InformationServiceImpl;
import comm.services.impl.SalleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {
    private final SalleServiceImpl salleService;

    private final InformationServiceImpl informationService;

    private final ConcertServiceImpl concertService;

    public SalleController(SalleServiceImpl salleService, InformationServiceImpl informationService, ConcertServiceImpl concertService) {
        this.salleService = salleService;
        this.informationService = informationService;
        this.concertService = concertService;
    }

    /**
     * Get all salles in the system
     * @return List<SalleDto>
     */
    @GetMapping
    public List<SalleDto> getSalles() {
        return salleService.getAllSalles();
    }

    /**
     * Method to get the salle based on the ID
     * @param id
     * @return SalleDto
     */
    @GetMapping("/{id}")
    public SalleDto getSalle(@PathVariable Long id) {
        return salleService.getSalleById(id);
    }

    /**
     * Renvoie l'ensemble des concerts associe a une salle
     * @param id
     * @return
     */
    @GetMapping("/{id}/concerts")
    public List<ConcertDto> getConcertsFromSalle(@PathVariable Long id) { return concertService.getAllConcertsFromSalle(id); }

    /**
     * Create a new Salle in the system
     * @param salleDto
     * @return SalleDto
     */
    @PostMapping
    public SalleDto saveSalle(final @RequestBody SalleDto salleDto) {
        return salleService.saveSalle(salleDto);
    }

    /**
     * Delete a Salle by it's id
     * @param id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSalle(@PathVariable Long id) {
        return salleService.deleteSalle(id);
    }

    /**
     * Method to get all the articles of a salle based on the ID
     * @param id
     * @return List<Information>
     */
    @GetMapping("/articles/{id}")
    public List<Information> getArticles(@PathVariable Long id) { return  informationService.getAllArticles(id, "salle"); }

    /**
     * Method to get all the photos of a salle based on the ID
     * @param id
     * @return List<Information>
     */
    @GetMapping("/photos/{id}")
    public List<Information> getPhotos(@PathVariable Long id) { return  informationService.getAllPhotos(id, "salle"); }

    @PostMapping("/informations")
    public Information saveInformation(final @RequestBody Information information) {
        return informationService.saveInformation(information);
    }
}

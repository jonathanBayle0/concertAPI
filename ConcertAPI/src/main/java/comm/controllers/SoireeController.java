package comm.controllers;

import comm.dtos.ConcertDto;
import comm.dtos.SoireeDto;
import comm.entities.Information;
import comm.services.impl.ConcertServiceImpl;
import comm.services.impl.InformationServiceImpl;
import comm.services.impl.SoireeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soirees")
public class SoireeController {
    private final SoireeServiceImpl soireeService;

    private final ConcertServiceImpl concertService;

    private final InformationServiceImpl informationService;

    public SoireeController(SoireeServiceImpl soireeService, ConcertServiceImpl concertService, InformationServiceImpl informationService) {
        this.soireeService = soireeService;
        this.concertService = concertService;
        this.informationService = informationService;
    }

    /**
     * <p>Get all soirees in the system</p>
     *
     * @return List<SoireeDto>
     */
    @GetMapping
    public List<SoireeDto> getSoirees() {
        return soireeService.getAllSoiree();
    }

    /**
     * Method to get the soiree based on the ID
     * @param id
     * @return SoireeDto
     */
    @GetMapping("/{id}")
    public SoireeDto getSoiree(@PathVariable Long id) {
        return soireeService.getSoireeById(id);
    }

    /**
     * Renvoie l'ensemble des concerts associe a une soiree
     * @param id
     * @return
     */
    @GetMapping("/{id}/concerts")
    public List<ConcertDto> getConcertsFromSoiree(@PathVariable Long id) { return concertService.getAllConcertsFromSoiree(id); }

    /**
     * Create a new Soiree in the system
     * @param soireeDto
     * @return SoireeDto
     */
    @PostMapping
    public SoireeDto saveSoiree(final @RequestBody SoireeDto soireeDto) {
        return soireeService.saveSoiree(soireeDto);
    }

    /**
     * Delete a Soiree by it's id
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSoiree(@PathVariable Long id) {
        return soireeService.deleteSoiree(id);
    }

    /**
     * Method to get all the articles of a soiree based on the ID
     * @param id
     * @return List<Information>
     */
    @GetMapping("/articles/{id}")
    public List<Information> getArticles(@PathVariable Long id) { return  informationService.getAllArticles(id, "soiree"); }

    /**
     * Method to get all the photos of a soiree based on the ID
     * @param id
     * @return List<Information>
     */
    @GetMapping("/photos/{id}")
    public List<Information> getPhotos(@PathVariable Long id) { return  informationService.getAllPhotos(id, "soiree"); }

    @PostMapping("/informations")
    public Information saveInformation(final @RequestBody Information information) {
        return informationService.saveInformation(information);
    }



}

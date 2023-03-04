package comm.controllers;

import comm.dtos.ConcertDto;
import comm.entities.Information;
import comm.services.impl.ConcertServiceImpl;
import comm.services.impl.InformationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertServiceImpl concertService;

    private final InformationServiceImpl informationService;

    public ConcertController(ConcertServiceImpl concertService, InformationServiceImpl informationService) {
        this.concertService = concertService;
        this.informationService = informationService;
    }

    /**
     * <p>Get all concert in the system</p>
     *
     * @return List<ConcertDto>
     */
    @GetMapping
    public List<ConcertDto> getConcerts() {
        return concertService.getAllConcerts();
    }

    /**
     * Method to get the concert based on the ID
     * @param id
     * @return ConcertDto
     */
    @GetMapping("/{id}")
    public ConcertDto getConcert(@PathVariable Long id) {
        return concertService.getConcertById(id);
    }

    /**
     * Method to get all the articles of a concert based on the ID
     * @param id
     * @return List<Information>
     */
    @GetMapping("/articles/{id}")
    public List<Information> getArticles(@PathVariable Long id) { return  informationService.getAllArticles(id, "concert"); }

    /**
     * Method to get all the photos of a concert based on the ID
     * @param id
     * @return List<Information>
     */
    @GetMapping("/photos/{id}")
    public List<Information> getPhotos(@PathVariable Long id) { return  informationService.getAllPhotos(id, "concert"); }

    /**
     * Create a new Concert in the system
     * @param concertDto
     * @return ConcertDto
     */
    @PostMapping
    public ConcertDto saveConcert(final @RequestBody ConcertDto concertDto) {
         return concertService.saveConcert(concertDto);
    }

    @PostMapping("/informations")
    public Information saveInformation(final @RequestBody Information information) {
        return informationService.saveInformation(information);
    }

    /**
     * Delete a Concert by it's id
     * @param id
     * @return Boolean
     */
    @DeleteMapping("/{id}")
    public Boolean deleteConcert(@PathVariable Long id) {
        return concertService.deleteConcert(id);
    }

    /**
     * Return all concert of a group
     * @param id GroupeId
     * @return
     */
    @GetMapping("/{id}/groupe")
    public List<ConcertDto> getConcertsByGroupe(@PathVariable Long id){

        return concertService.getAllConcertsByGroupe(id);
    }
}

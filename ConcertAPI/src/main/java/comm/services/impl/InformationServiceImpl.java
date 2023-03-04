package comm.services.impl;

import comm.entities.Information;
import comm.repositories.InformationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("informationService")
public class InformationServiceImpl {
    private final InformationRepository informationRepository;

    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    /**
     * Sauvegarde d'un élément dans la collection
     * @param information
     * @return
     */
    public Information saveInformation(Information information) {
        return informationRepository.save(information);
    }

    /**
     * Retourne l'ensemble des articles associe a un objet
     * @return
     */
    public List<Information> getAllArticles(Long id, String type) {
        List<Information> informations = informationRepository.findByInfType(type);
        List<Information> articles = new ArrayList<>();
        String stringId = id.toString();
        for (Information inf : informations) {
            if (inf.getInfTypeContenu().equals("article") && inf.getInfCible().equals(stringId)) articles.add(inf);
        }
        return articles;
    }
    /**
     * Retourne l'ensemble des photos associe a un objet
     * @return
     */
    public List<Information> getAllPhotos(Long id, String type) {
        List<Information> informations = informationRepository.findByInfType(type);
        List<Information> photos = new ArrayList<>();
        String stringId = id.toString();
        for (Information inf : informations) {
            if (inf.getInfTypeContenu().equals("photo") && inf.getInfCible().equals(stringId)) photos.add(inf);
        }
        return photos;
    }
}

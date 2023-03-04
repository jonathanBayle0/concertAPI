package comm.repositories;

import comm.entities.Information;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InformationRepository extends MongoRepository<Information, String> {
    List<Information> findByInfType(String infType);
}

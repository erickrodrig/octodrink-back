package octodrink.back.bebida;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends MongoRepository<Bebida, String> {
}

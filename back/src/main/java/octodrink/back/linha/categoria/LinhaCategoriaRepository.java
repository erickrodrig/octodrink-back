package octodrink.back.linha.categoria;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinhaCategoriaRepository extends MongoRepository<LinhaCategoria, String> {
}

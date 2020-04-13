package octodrink.back.linha.categoria;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinhaCategoriaRepository extends MongoRepository<LinhaCategoria, String> {
    List<LinhaCategoria> findAllByCategoria_Id(String catId);

    boolean existsByNome(String nome);
}
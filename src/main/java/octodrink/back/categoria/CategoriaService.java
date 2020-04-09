package octodrink.back.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    private Categoria buildCat(Categoria categoria, CategoriaDTO dto){
        categoria.setNome(dto.getNome());

        return categoria;
    }

    public CategoriaDTO save(CategoriaDTO dto){
        Categoria categoria = new Categoria();

        buildCat(categoria, dto);

        return CategoriaDTO.of(repository.save(categoria));
    }

    public Categoria findById(String id){
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        throw new HttpServerErrorException(HttpStatus.NOT_FOUND, String.format("Categoria de ID '%s' não encontrada.", id));
    }

    public CategoriaDTO update(CategoriaDTO dto){
        Categoria categoria = findById(dto.getId());

        buildCat(categoria, dto);

        return CategoriaDTO.of(repository.save(categoria));
    }

    public void delete(String id){
        findById(id);

        repository.deleteById(id);
    }
}

package octodrink.back.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    private Categoria buildCat(Categoria categoria, CategoriaDTO categoriaDTO){
        categoria.setNome(categoriaDTO.getNome());
        categoria.setCodigo(categoriaDTO.getCodigo());

        return categoria;
    }

    public CategoriaDTO save(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();

        buildCat(categoria, categoriaDTO);

        return CategoriaDTO.of(repository.save(categoria));
    }

    public Categoria findById(String id){
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        throw new HttpServerErrorException(HttpStatus.NOT_FOUND, String.format("Categoria de ID '%s' não encontrada.", id));
    }

    public CategoriaDTO update(CategoriaDTO categoriaDTO){
        Categoria categoria = findById(categoriaDTO.getId());

        buildCat(categoria, categoriaDTO);

        return CategoriaDTO.of(repository.save(categoria));
    }

    public void delete(String id){
        findById(id);

        repository.deleteById(id);
    }
}

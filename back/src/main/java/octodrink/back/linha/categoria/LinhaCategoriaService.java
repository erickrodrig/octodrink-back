package octodrink.back.linha.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class LinhaCategoriaService {
    @Autowired
    private LinhaCategoriaRepository repository;

    private LinhaCategoria constructObj(LinhaCategoria linhaCategoria, LinhaCategoriaDTO dto){
        linhaCategoria.setNome(dto.getNome());
        linhaCategoria.setCodigo(dto.getCodigo());
        linhaCategoria.setCategoria(dto.getCategoria());

        return linhaCategoria;
    }

    public LinhaCategoriaDTO save(LinhaCategoriaDTO dto){
        LinhaCategoria linhaCategoria = new LinhaCategoria();

        constructObj(linhaCategoria, dto);

        return LinhaCategoriaDTO.of(repository.save(linhaCategoria));
    }

    public LinhaCategoria findById(String id){
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }

        throw new HttpServerErrorException(HttpStatus.NOT_FOUND, String.format("Linha de categoria de ID '%s' não encontrada.", id));
    }

    public LinhaCategoriaDTO update(LinhaCategoriaDTO dto){
        LinhaCategoria linhaCategoria = findById(dto.getId());

        constructObj(linhaCategoria, dto);

        return LinhaCategoriaDTO.of(repository.save(linhaCategoria));
    }

    public void delete(String id){
        findById(id);

        repository.deleteById(id);
    }
}

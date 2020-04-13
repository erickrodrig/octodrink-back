package octodrink.back.linha.categoria;

import octodrink.back.categoria.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinhaCategoriaService {
    @Autowired
    private LinhaCategoriaRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public LinhaCategoriaService(LinhaCategoriaRepository repository, CategoriaService categoriaService) {
        this.repository = repository;
        this.categoriaService = categoriaService;
    }

    public LinhaCategoriaDTO save(LinhaCategoriaDTO dto) {
        LinhaCategoria linhaCategoria = new LinhaCategoria();

        buildObj(linhaCategoria, dto);

        return LinhaCategoriaDTO.of(repository.save(linhaCategoria));
    }

    public LinhaCategoria findById(String id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }

        throw new IllegalArgumentException(String.format("Linha de categoria de ID '%s' não encontrada.", id));
    }

    public LinhaCategoriaDTO update(LinhaCategoriaDTO dto) {
        LinhaCategoria linhaCategoria = findById(dto.getId());

        buildObj(linhaCategoria, dto);

        return LinhaCategoriaDTO.of(repository.save(linhaCategoria));
    }

    public void delete(String id) {
        findById(id);

        repository.deleteById(id);
    }

    private void buildObj(LinhaCategoria linhaCategoria, LinhaCategoriaDTO dto) {
        validateNome(dto.getNome());
        linhaCategoria.setNome(dto.getNome());
        linhaCategoria.setCategoria(categoriaService.findById(dto.getCategoria()));
    }

    public void updateCat(String catId) {
        List<LinhaCategoria> list = repository.findAllByCategoria_Id(catId);
        for (LinhaCategoria linhaCat : list) {
            linhaCat.setCategoria(categoriaService.findById(catId));
        }
        repository.saveAll(list);
    }

    private void validateNome(String nome) {
        if (repository.existsByNome(nome)) {
            throw new IllegalArgumentException("Nome de linha de categoria já existente.");
        }
    }
}

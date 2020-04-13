package octodrink.back.categoria;

import octodrink.back.linha.categoria.LinhaCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private LinhaCategoriaService linhaCategoriaService;

    public CategoriaService(CategoriaRepository repository, LinhaCategoriaService linhaCategoriaService) {
        this.repository = repository;
        this.linhaCategoriaService = linhaCategoriaService;
    }

    public CategoriaDTO save(CategoriaDTO dto) {
        Categoria categoria = new Categoria();

        buildObj(categoria, dto);

        return CategoriaDTO.of(repository.save(categoria));
    }

    public Categoria findById(String id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        throw new IllegalArgumentException(String.format("Categoria de ID '%s' não encontrada.", id));
    }

    public CategoriaDTO update(CategoriaDTO dto) {
        Categoria categoria = findById(dto.getId());
        buildObj(categoria, dto);
        CategoriaDTO categoriaDTO = CategoriaDTO.of(repository.save(categoria));
        linhaCategoriaService.updateCat(dto.getId());

        return categoriaDTO;
    }

    public void delete(String id) {
        findById(id);

        repository.deleteById(id);
    }

    private void buildObj(Categoria categoria, CategoriaDTO dto) {
        validateNome(dto.getNome());
        categoria.setNome(dto.getNome());
    }

    private void validateNome(String nome) {
        if (repository.existsByNome(nome)) {
            throw new IllegalArgumentException("Nome de categoria já existente.");
        }
    }
}

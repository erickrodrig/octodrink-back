package octodrink.back.bebida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class BebidaService {
    @Autowired
    private final BebidaRepository repository;

    public BebidaService(BebidaRepository repository) {
        this.repository = repository;
    }

    private void buildObj(Bebida bebida, BebidaDTO dto){
        bebida.setNome(dto.getNome());
        bebida.setCodigo(dto.getCodigo());
        bebida.setDescricao(dto.getDescricao());
        bebida.setQtdCaixa(dto.getQtdCaixa());
        bebida.setPreco(dto.getPreco());
        bebida.setPeso(dto.getPeso());
        bebida.setUnPeso(dto.getUnPeso());
        bebida.setValidade(dto.getValidade());
        bebida.setLinhaCategoria(dto.getLinhaCategoria());
    }

    public BebidaDTO save(BebidaDTO dto) {
        Bebida bebida = new Bebida();

        buildObj(bebida, dto);

        return BebidaDTO.of(repository.save(bebida));
    }

    public Bebida findById(String id) throws HttpStatusCodeException {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        throw new HttpServerErrorException(HttpStatus.NOT_FOUND, String.format("Bebida de ID '%s' não encontrada.", id));
    }

    public BebidaDTO update(BebidaDTO dto){
        Bebida bebida = findById(dto.getId());

        buildObj(bebida, dto);

        return BebidaDTO.of(repository.save(bebida));
    }

    public void delete(String id){
        findById(id);

        repository.deleteById(id);
    }
}

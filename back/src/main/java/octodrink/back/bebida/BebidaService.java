package octodrink.back.bebida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class BebidaService {
    @Autowired
    private final BebidaRepository bebidaRepository;

    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    private Bebida buildObj(Bebida bebida, BebidaDTO bebidaDTO){
        bebida.setNome(bebidaDTO.getNome());
        bebida.setCodigo(bebidaDTO.getCodigo());
        bebida.setDescricao(bebidaDTO.getDescricao());
        bebida.setQtdCaixa(bebidaDTO.getQtdCaixa());
        bebida.setPreco(bebidaDTO.getPreco());
        bebida.setPeso(bebidaDTO.getPeso());
        bebida.setValidade(bebidaDTO.getValidade());
        bebida.setLinhaCategoria(bebidaDTO.getLinhaCategoria());

        return bebida;
    }

    public BebidaDTO save(BebidaDTO bebidaDTO) {
        Bebida bebida = new Bebida();

        buildObj(bebida, bebidaDTO);

        return BebidaDTO.of(bebidaRepository.save(bebida));
    }

    public Bebida findById(String id) throws HttpStatusCodeException {
        if (bebidaRepository.findById(id).isPresent()) {
            return bebidaRepository.findById(id).get();
        }
        throw new HttpServerErrorException(HttpStatus.NOT_FOUND, String.format("Bebida de ID '%s' não encontrada.", id));
    }

    public BebidaDTO update(BebidaDTO bebidaDTO){
        Bebida bebida = findById(bebidaDTO.getId());

        buildObj(bebida, bebidaDTO);

        return BebidaDTO.of(bebidaRepository.save(bebida));
    }

    public void delete(String id){
        findById(id);

        bebidaRepository.deleteById(id);
    }
}

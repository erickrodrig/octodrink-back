package octodrink.back.bebida;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Random;

@Service
public class BebidaService {
    @Autowired
    private final BebidaRepository repository;

    public BebidaService(BebidaRepository repository) {
        this.repository = repository;
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
        throw new IllegalArgumentException(String.format("Bebida de ID '%s' não encontrada.", id));
    }

    public BebidaDTO update(BebidaDTO dto) {
        Bebida bebida = findById(dto.getId());

        buildObj(bebida, dto);

        return BebidaDTO.of(repository.save(bebida));
    }

    public void delete(String id) {
        findById(id);

        repository.deleteById(id);
    }

    private void buildObj(Bebida bebida, BebidaDTO dto) {
        bebida.setNome(dto.getNome());
        bebida.setCodigo(codigoRandom());
        bebida.setDescricao(dto.getDescricao());
        bebida.setQtdCaixa(dto.getQtdCaixa());
        bebida.setPreco(dto.getPreco());
        bebida.setPeso(dto.getPeso());
        bebida.setUnPeso(dto.getUnPeso());
        bebida.setValidade(dto.getValidade());
        bebida.setLinhaCategoria(dto.getLinhaCategoria());
        bebida.setImg(dto.getImg());
    }

    private String codigoRandom() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder codigo = new StringBuilder();

        while (codigo.length() < 3) {
            codigo.append(letters.charAt(new Random().nextInt(letters.length())));
        }

        codigo.append(StringUtils.leftPad(String.valueOf(new Random().nextInt(999)), 3, "0"));

        return codigo.toString();
    }
}

package octodrink.back.linha.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LinhaCategoriaDTO {
    private String id;

    @NotBlank
    @Size(min = 2, max = 50, message = "Tamanho do nome inválido. Deve conter entre 2 e 50 caracteres.")
    private String nome;

    @NotBlank
    private String categoria;

    public LinhaCategoriaDTO(String id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public static LinhaCategoriaDTO of(LinhaCategoria linhaCategoria) {
        return new LinhaCategoriaDTO(
                linhaCategoria.getId(),
                linhaCategoria.getNome(),
                linhaCategoria.getCategoria().getId()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

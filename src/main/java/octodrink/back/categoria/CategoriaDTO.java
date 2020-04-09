package octodrink.back.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoriaDTO {
    private String id;

    @NotBlank
    @Size(min = 2, max = 50, message = "Tamanho do nome inválido. Deve conter entre 2 e 50 caracteres.")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static CategoriaDTO of (Categoria categoria){
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNome()
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
}

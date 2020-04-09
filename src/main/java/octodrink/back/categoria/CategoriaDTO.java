package octodrink.back.categoria;

public class CategoriaDTO {
    private String id;
    private String nome;

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

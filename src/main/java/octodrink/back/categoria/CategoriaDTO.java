package octodrink.back.categoria;

public class CategoriaDTO {
    private String id;
    private String nome;
    private String codigo;

    public CategoriaDTO(String id, String nome, String codigo) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
    }

    public static CategoriaDTO of (Categoria categoria){
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getCodigo()
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}

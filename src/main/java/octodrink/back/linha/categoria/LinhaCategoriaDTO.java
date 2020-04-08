package octodrink.back.linha.categoria;

import octodrink.back.categoria.Categoria;

public class LinhaCategoriaDTO {
    private String id;
    private String nome;
    private String codigo;
    private Categoria categoria;

    public LinhaCategoriaDTO(String id, String nome, String codigo, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.categoria = categoria;
    }

    public static LinhaCategoriaDTO of (LinhaCategoria linhaCategoria){
        return new LinhaCategoriaDTO(
                linhaCategoria.getId(),
                linhaCategoria.getNome(),
                linhaCategoria.getCodigo(),
                linhaCategoria.getCategoria()
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

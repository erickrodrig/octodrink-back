package octodrink.back.linha.categoria;

import octodrink.back.categoria.Categoria;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("linhaCategoria")
public class LinhaCategoria {
    @Id
    String id;
    String nome;
    String codigo;
    Categoria categoria;

    public LinhaCategoria() {
    }

    public LinhaCategoria(String nome, String codigo, Categoria categoria) {
        this.nome = nome;
        this.codigo = codigo;
        this.categoria = categoria;
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

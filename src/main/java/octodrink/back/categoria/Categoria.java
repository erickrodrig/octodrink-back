package octodrink.back.categoria;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categoria")
public class Categoria {
    @Id
    private String id;
    private String nome;
    private String codigo;

    public Categoria() {
    }

    public Categoria(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
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

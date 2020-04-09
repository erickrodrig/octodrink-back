package octodrink.back.bebida;

import complements.enums.UnPeso;
import octodrink.back.linha.categoria.LinhaCategoria;
import complements.classes.Image;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("bebida")
public class Bebida {
    @Id
    private String id;
    private String nome;
    private String codigo;
    private String descricao;
    private Integer qtdCaixa;
    private Double preco;
    private Double peso;
    private UnPeso unPeso;
    private LocalDate validade;
    private LinhaCategoria linhaCategoria;
    private Image img;

    public Bebida() {
    }

    public Bebida(String nome, String codigo, String descricao, Integer qtdCaixa, Double preco, Double peso, UnPeso unPeso, LocalDate validade, LinhaCategoria linhaCategoria, Image img) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtdCaixa = qtdCaixa;
        this.preco = preco;
        this.peso = peso;
        this.unPeso = unPeso;
        this.validade = validade;
        this.linhaCategoria = linhaCategoria;
        this.img = img;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtdCaixa() {
        return qtdCaixa;
    }

    public void setQtdCaixa(Integer qtdCaixa) {
        this.qtdCaixa = qtdCaixa;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public UnPeso getUnPeso() {
        return unPeso;
    }

    public void setUnPeso(UnPeso unPeso) {
        this.unPeso = unPeso;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public LinhaCategoria getLinhaCategoria() {
        return linhaCategoria;
    }

    public void setLinhaCategoria(LinhaCategoria linhaCategoria) {
        this.linhaCategoria = linhaCategoria;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}

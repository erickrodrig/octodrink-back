package octodrink.back.bebida;

import octodrink.back.linha.categoria.LinhaCategoria;

import java.time.LocalDate;

public class BebidaDTO {
    private String id;
    private String nome;
    private String codigo;
    private String descricao;
    private Integer qtdCaixa;
    private Double preco;
    private Double peso;
    private LocalDate validade;
    private LinhaCategoria linhaCategoria;

    public BebidaDTO(String id, String nome, String codigo, String descricao, Integer qtdCaixa, Double preco, Double peso, LocalDate validade, LinhaCategoria linhaCategoria) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtdCaixa = qtdCaixa;
        this.preco = preco;
        this.peso = peso;
        this.validade = validade;
        this.linhaCategoria = linhaCategoria;
    }

    public static BebidaDTO of (Bebida bebida){
        return new BebidaDTO(
                bebida.getId(),
                bebida.getNome(),
                bebida.getCodigo(),
                bebida.getDescricao(),
                bebida.getQtdCaixa(),
                bebida.getPreco(),
                bebida.getPeso(),
                bebida.getValidade(),
                bebida.getLinhaCategoria()
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
}

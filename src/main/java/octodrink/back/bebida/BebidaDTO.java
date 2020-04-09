package octodrink.back.bebida;

import complements.classes.Image;
import complements.enums.UnPeso;
import octodrink.back.linha.categoria.LinhaCategoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class BebidaDTO {
    private String id;
    private String codigo;
    private Image img;

    @NotBlank
    @Size(min = 2, max = 50, message = "Tamanho do nome inválido. Deve conter entre 2 e 50 caracteres.")
    private String nome;
    @NotBlank
    @Size(min = 5, max = 250, message = "Tamanho da descrição inválido. Deve conter entre 5 e 250 caracteres.")
    private String descricao;
    @NotNull
    private Integer qtdCaixa;
    @NotNull
    private Double preco;
    @NotNull
    private Double peso;
    @NotNull
    private UnPeso unPeso;
    @NotNull
    private LocalDate validade;
    @NotNull
    private LinhaCategoria linhaCategoria;

    public BebidaDTO() {
    }

    public BebidaDTO(String id, String codigo, Image img, @NotBlank @Size(min = 2, max = 50, message = "Tamanho do nome inválido. Deve conter entre 2 e 50 caracteres.") String nome, @NotBlank @Size(min = 5, max = 250, message = "Tamanho da descrição inválido. Deve conter entre 5 e 250 caracteres.") String descricao, @NotNull Integer qtdCaixa, @NotNull Double preco, @NotNull Double peso, @NotNull UnPeso unPeso, @NotNull LocalDate validade, @NotNull LinhaCategoria linhaCategoria) {
        this.id = id;
        this.codigo = codigo;
        this.img = img;
        this.nome = nome;
        this.descricao = descricao;
        this.qtdCaixa = qtdCaixa;
        this.preco = preco;
        this.peso = peso;
        this.unPeso = unPeso;
        this.validade = validade;
        this.linhaCategoria = linhaCategoria;
    }

    public static BebidaDTO of (Bebida bebida){
        return new BebidaDTO(
                bebida.getId(),
                bebida.getCodigo(),
                bebida.getImg(),
                bebida.getNome(),
                bebida.getDescricao(),
                bebida.getQtdCaixa(),
                bebida.getPreco(),
                bebida.getPeso(),
                bebida.getUnPeso(),
                bebida.getValidade(),
                bebida.getLinhaCategoria());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}

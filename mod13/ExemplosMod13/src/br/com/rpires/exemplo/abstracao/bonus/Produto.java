package br.com.rpires.exemplo.abstracao.bonus;

import java.util.Objects;

/**
 * @author rodrigo.pires
 */
public abstract class Produto {

    private Long codigo;

    private String nome;

    private Double preco;

    private Long quantidade;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addQuantidade() {
        this.quantidade++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo) && Objects.equals(nome, produto.nome) && Objects.equals(preco, produto.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, preco);
    }
}

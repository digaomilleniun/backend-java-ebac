package br.com.rpires.domain;

/**
 * @author rodrigo.pires
 */
public class Produto {

    private int codigo;
    private String nome;
    private int estoque;
    private float valor;

    public Produto(int codigo, String nome, int estoque, float valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.estoque = estoque;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void entradaEstoque(int quantidade) {
        estoque += quantidade;
    }

    public void saidaEstoque(int quantidade) {
        estoque -= quantidade;
    }
}

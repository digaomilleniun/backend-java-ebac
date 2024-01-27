package br.com.rpires.domain;

/**
 * @author rodrigo.pires
 */
public class ItemVenda {

    private int quantidade;
    private Produto_4 produto;

    public ItemVenda(int quantidade, Produto_4 produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto_4 getProduto() {
        return produto;
    }

    public void setProduto(Produto_4 produto) {
        this.produto = produto;
    }

    public float calcularValorTotalItem(){
        return quantidade * produto.getValor();
    }
}

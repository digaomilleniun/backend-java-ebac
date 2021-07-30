package br.com.rpires.agregacao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rodrigo.pires
 */
public class Venda {

    private Comprador comprador;

    private Vendedor vendedor;

    private List<Produto> produtos;

    public Venda() {
        this.produtos = new ArrayList<>();
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void add(Produto produto) {
        this.produtos.add(produto);
    }
    
    public void concretizarVenda() {
        System.out.println("Comprador " + this.comprador.getNome());
        System.out.println("Comprou os Itens : ");
        for (Produto prod : this.produtos) {
            System.out.println("Nome produto " + prod.getNome() + " Valor produto " + prod.getPreco());
        }
        System.out.println("Vendedor: " + this.vendedor.getNome());
    }

    public void cancelarVenda() {
        System.out.println("Venda cancelada");
    }

    @Override
    public String toString() {
        return "Venda{" +
                "comprador=" + comprador.getNome() +
                ", vendedor=" + vendedor.getNome() +
                ", produtos=" + produtos +
                '}';
    }
}

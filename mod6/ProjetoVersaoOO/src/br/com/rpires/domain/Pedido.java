package br.com.rpires.domain;

import java.math.BigDecimal;

/**
 * @author rodrigo.pires
 */
public class Pedido {

    private Cliente_2 cliente;
    private final Vendedor vendedor;
    private final ItemVenda[] itens;

    public Pedido(Cliente_2 cliente, Vendedor vendedor, ItemVenda[] itens) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }

    public Cliente_2 getCliente() {
        return cliente;
    }

    public void setCliente(Cliente_2 cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public ItemVenda[] getItens() {
        return itens;
    }

    public float calcularValorTotalPedido() {
        float valorTotal = 0;
        for (ItemVenda item : itens) {
            valorTotal = valorTotal + item.calcularValorTotalItem();
        }
        return valorTotal;
    }

    public float calcularComissaoPedido() {
        return calcularValorTotalPedido() * vendedor.getPercentualComissao();
    }

    public void realizarVenda() {

        // Remove os produtos vendidos do estoque:
        for (ItemVenda itemVenda : getItens()) {
            Produto_4 produto = itemVenda.getProduto();
            String nomeProduto = produto.getNome();
            BigDecimal valorProduto = produto.getValor();
            int estoqueProduto = produto.getEstoque();
            int qtdeItem = itemVenda.getQuantidade();
            float totalItem = itemVenda.calcularValorTotalItem();
            produto.saidaEstoque(qtdeItem);
            System.out.println("Item Pedido: Produto:");
            System.out.println("  Nome do produto  = " + nomeProduto);
            System.out.println("  Estoque Anterior = " + estoqueProduto);
            System.out.println("   Quantidade Item = " + qtdeItem);
            System.out.println("             Valor = " + valorProduto);
            System.out.println("        Total Item = " + totalItem);
        }

        // Busca nome do vendedor e calcula comissão do vendedor:
        float percentualComissao = getVendedor().getPercentualComissao();
        String nomeVendedor = getVendedor().getNome();
        System.out.println("Nome do Vendedor: " + nomeVendedor);
        System.out.println("Percentual de Comissão: " + percentualComissao);

        // Busca nome do cliente:
        String nomeCliente = getCliente().getNome();
        String enderecoCliente = getCliente().getEndereco();
        System.out.println("Nome do Cliente: " + nomeCliente);
        System.out.println("Endereço do Cliente: " + enderecoCliente);

        // Acessa os dados totais:
        float totalPedido = calcularValorTotalPedido();
        float totalComissao = calcularComissaoPedido();
        System.out.println("Valor Total do pedido: " + totalPedido);
        System.out.println("Valor Total da Comissão: " + totalComissao);
    }
}


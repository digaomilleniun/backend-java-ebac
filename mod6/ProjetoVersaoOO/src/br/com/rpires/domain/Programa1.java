package br.com.rpires.domain;

import java.util.List;

/**
 * @author rodrigo.pires
 */
public class Programa1 {

    public static void main(String[] args) {
        List<Pedido> pedidos = criarPedidos();
        for (int i=0; i<pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            System.out.println("***************************");
            System.out.println("Iniciando Venda (" + i + ")");
            pedido.realizarVenda();
            System.out.println("Venda Concluída (" + i + ")");
            System.out.println("***************************");
        }
    }

    private static List<Pedido> criarPedidos() {
        Pedido pedido1 = criarPedido1();
        Pedido pedido2 = criarPedido2();
        Pedido pedido3 = criarPedido3();
        Pedido pedido4 = criarPedido4();
        return List.of(pedido1, pedido2, pedido3, pedido4);
    }

    private static Pedido criarPedido1() {
        Produto_4 produtoMesa = cadastrarProduto(1, "Mesa", 10, 500);
        ItemVenda[] item1 = {new ItemVenda(1, produtoMesa)};
        Cliente_2 cliente1 = cadastrarCliente(1,"João", "Rua X, 100");
        Vendedor vendedor1 = cadastrarVendedor(1, "Vendedor 1");
        return new Pedido(cliente1, vendedor1, item1);
    }

    private static Pedido criarPedido2() {
        Produto_4 produtoCadeira = cadastrarProduto(2, "Cadeira", 20, 150);
        Cliente_2 cliente2 = cadastrarCliente(2,"Carlos", "Rua Y, 200");
        Vendedor vendedor2 = cadastrarVendedor(2, "Vendedor 2");
        ItemVenda[] item2 = {new ItemVenda(2, produtoCadeira)};
        return new Pedido(cliente2, vendedor2, item2);
    }

    private static Pedido criarPedido3() {
        Produto_4 produtoFogao = cadastrarProduto(3, "Fogão", 5, 1000);
        Cliente_2 cliente3 = cadastrarCliente(3,"Carina", "Rua Z, 400");
        Vendedor vendedor3 = cadastrarVendedor(3, "Vendedor 3");
        ItemVenda[] item3 = {new ItemVenda(3, produtoFogao)};
        return new Pedido(cliente3, vendedor3, item3);
    }

    private static Pedido criarPedido4() {
        Produto_4 produtoSofa = cadastrarProduto(4, "Sofá", 5, 2000);
        Cliente_2 cliente4 = cadastrarCliente(4,"Paula", "Rua A, 500");
        Vendedor vendedor4 = cadastrarVendedor(4, "Vendedor 4");
        ItemVenda[] item4 = {new ItemVenda(4, produtoSofa)};
        return new Pedido(cliente4, vendedor4, item4);
    }

    private static Vendedor cadastrarVendedor(int codigo, String nome) {
        return new Vendedor(codigo, nome, (float) 0.1);
    }

    private static Cliente_2 cadastrarCliente(int codigo, String nome, String endereco) {
        return new Cliente_2(codigo,nome, endereco);
    }

    private static Produto_4 cadastrarProduto(int codigo, String nome, int estoque, float valor) {
        return new Produto_4(codigo, nome, estoque, valor);
    }
}

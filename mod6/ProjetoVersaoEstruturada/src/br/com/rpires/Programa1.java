package br.com.rpires;

/**
 * @author rodrigo.pires
 */
public class Programa1 {

    private static int[] codigoProdutos;
    private static String[] nomeProdutos;
    private static float[] valorProdutos;
    private static int[] estoqueProdutos;
    private static int[] codigoClientes;
    private static String[] nomeClientes;
    private static String[] enderecoClientes;
    private static int[] codigoProdutosVendidos;
    private static int[] qtdeVendidaProdutos;
    private static int[] codigoVendedores;
    private static String[] nomeVendedores;
    private static float[] percentualComissaoVendedores;
    private static int codigoClienteVenda;
    private static int codigoVendedorVenda;

    public static void main(String[] args) {
        System.out.println("Iniciando Venda (1).");
        criarDadosTeste();
        realizarVenda();
        System.out.println("Venda Concluída.");
    }

    private static void criarDadosTeste() {
        codigoProdutos = new int[] { 1, 2, 3, 4 };
        nomeProdutos = new String[] { "Mesa", "Cadeira", "Fogão", "Sofá" };
        valorProdutos = new float[] { 500, 150, 1000, 2000 };
        estoqueProdutos = new int[] { 10, 20, 5, 4 };
        codigoClientes = new int[] { 1, 2, 3 };
        nomeClientes = new String[] { "João", "Carlos", "Carina" };
        enderecoClientes = new String[] { "Rua X, 100", "Rua Y, 200", "Rua Z, 400" };
        codigoProdutosVendidos = new int[] { 1, 2, 3 };
        qtdeVendidaProdutos = new int[] { 1, 6, 1 };
        codigoVendedores = new int[] { 1, 2 };
        nomeVendedores = new String[] { "Ademar", "Rosália" };
        percentualComissaoVendedores = new float[] { 0.1f, 0.2f };
        codigoClienteVenda = 2;
        codigoVendedorVenda = 1;
    }

    private static void realizarVenda() {

        float totalPedido = 0;

        // Remove os produtos vendidos do estoque e calcula o total:
        for (int contProdutoVendido = 0; contProdutoVendido < codigoProdutosVendidos.length; contProdutoVendido++) {
            int codigoProdutoVendido = codigoProdutosVendidos[contProdutoVendido];
            for (int contProduto = 0; contProduto < codigoProdutos.length; contProduto++) {
                int codigoProduto = codigoProdutos[contProduto];
                if (codigoProdutoVendido == codigoProduto) {
                    String nomeProduto = nomeProdutos[contProduto];
                    float valorProduto = valorProdutos[contProduto];
                    int estoqueProduto = estoqueProdutos[contProduto];
                    int qtdeItem = qtdeVendidaProdutos[contProduto];
                    float totalItem = valorProduto * qtdeItem;
                    estoqueProdutos[contProduto] = estoqueProduto - qtdeItem;
                    totalPedido = totalPedido + totalItem;
                    System.out.println("Item Pedido: Produto:");
                    System.out.println("  Nome do produto  = " + nomeProduto);
                    System.out.println("  Estoque Anterior = " + estoqueProduto);
                    System.out.println("   Quantidade Item = " + qtdeItem);
                    System.out.println("             Valor = " + valorProduto);
                    System.out.println("        Total Item = " + totalItem);
                }
            }
        }

        // Busca nome do vendedor e calcula a comissão:
        float percentualComissao = 0;
        for (int contVendedor = 0; contVendedor < codigoVendedores.length; contVendedor++) {
            int codigoVendedorLista = codigoVendedores[contVendedor];
            if (codigoVendedorLista == codigoVendedorVenda) {
                percentualComissao = percentualComissaoVendedores[contVendedor];
                String nomeVendedor = nomeVendedores[contVendedor];
                System.out.println("Nome do Vendedor: " + nomeVendedor);
                System.out.println("Percentual de Comissão: " + percentualComissao);
                break;
            }
        }
        float totalComissao = totalPedido * percentualComissao;

        // Busca nome do cliente:
        for (int contCliente = 0; contCliente < codigoClientes.length; contCliente++) {
            int codigoClienteLista = codigoClientes[contCliente];
            if (codigoClienteLista == codigoClienteVenda) {
                String nomeCliente = nomeClientes[contCliente];
                String enderecoCliente = enderecoClientes[contCliente];
                System.out.println("Nome do Cliente: " + nomeCliente);
                System.out.println("Endereço do Cliente: " + enderecoCliente);
                break;
            }
        }

        // Acessa os dados totais:
        System.out.println("Valor Total do pedido: " + totalPedido);
        System.out.println("Valor Total da Comissão: " + totalComissao);
    }

}

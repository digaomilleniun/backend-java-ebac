package br.com.rpires.exemplo.abstracao.bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author rodrigo.pires
 */
public class App {
    

    public static void main(String args[]) {
        List<Produto> produtos = getProdutosAleatorios(10);
        Pedido pedido = new Pedido();
        produtos.forEach(prod-> pedido.add(prod));
        pedido.concluirVenda();
    }

    public static List<Produto> getProdutosAleatorios(int quantidade) {
        List<Produto> produtos = new ArrayList<>();
        List<Produto> produtosCadastrados = ClasseGeraProdutos.criarProdutos(100);

        Random r = new Random();
        for (int i=0; i<quantidade; i++) {
            int numAleatorio1 = r.nextInt(produtosCadastrados.size());
            Produto prod = produtosCadastrados.get(numAleatorio1);
            produtos.add(prod);
        }
        return produtos;
    }
}

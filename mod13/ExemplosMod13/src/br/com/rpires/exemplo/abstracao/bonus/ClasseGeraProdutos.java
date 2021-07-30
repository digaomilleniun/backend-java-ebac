package br.com.rpires.exemplo.abstracao.bonus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rodrigo.pires
 */
public class ClasseGeraProdutos {

    public static List<Produto> criarProdutos(int quantidade) {
        List<Produto> produtos = new ArrayList<>();
        for (int i=0; i<quantidade; i++) {
            Produto prodDoce = criarDoce(i);
            Produto prodPao = criarPao(i);
            Produto prodFrios = criarFrios(i);
            produtos.add(prodDoce);
            produtos.add(prodPao);
            produtos.add(prodFrios);
        }
        return produtos;
    }

    private static Produto criarDoce(int indice) {
        Produto prod = new Doces();
        prod.setNome("Doce");
        prod.setQuantidade(1l);
        prod.setPreco(10d);
        prod.setCodigo(1l);
        return prod;
    }

    private static Produto criarPao(int indice) {
        Produto prod = new Pao();
        prod.setNome("Pao");
        prod.setQuantidade(1l);
        prod.setPreco(10d);
        prod.setCodigo(2l);
        return prod;
    }

    private static Produto criarFrios(int indice) {
        Produto prod = new Frios();
        prod.setNome("Frios");
        prod.setQuantidade(1l);
        prod.setPreco(10d);
        prod.setCodigo(3l);
        return prod;
    }
}

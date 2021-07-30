package br.com.rpires.exemplo.abstracao.bonus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rodrigo.pires
 */
public class PedidoMapa {

    private Map<Long, Produto> produtos;

    public PedidoMapa() {
        this.produtos = new HashMap<>();
    }

    public void add(Produto produto) {
        Produto prodCadastrado = this.produtos.get(produto.getCodigo());
        if (prodCadastrado == null) {
            this.produtos.put(produto.getCodigo(), produto);
        } else {
            prodCadastrado.addQuantidade();
        }
    }

    public void concluirVenda() {
        this.produtos.forEach((key, value) -> {
            System.out.println("Quantidade vendida: " + value.getQuantidade() + " do produto: " + value.getNome());
        });
    }
}

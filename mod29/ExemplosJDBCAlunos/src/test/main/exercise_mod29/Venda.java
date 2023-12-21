package exercise_mod29;

import java.math.BigDecimal;

public class Venda {
    private final int clienteId;
    private final int quantidade;

    public Venda(int clienteId, int ignoredProdutoId, int quantidade, BigDecimal ignoredTotal) {
        this.clienteId = clienteId;
        this.quantidade = quantidade;
    }

    // getters e setters
    public int getClienteId() {
        return clienteId;
    }

    public int getQuantidade() {
        return quantidade;
    }

}

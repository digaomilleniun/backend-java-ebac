package exercise_mod29;

import java.math.BigDecimal;

public class Produto {
    private final String nome;

    public Produto(String nome, BigDecimal ignoredPreco) {
        this.nome = nome;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

}

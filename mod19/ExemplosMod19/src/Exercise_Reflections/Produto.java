package Exercise_Reflections;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Tabela {
    String nome();
}

@Tabela(nome = "produtos") // Atribui a anotação "Tabela" à classe Produto com o nome da tabela no banco de dados

class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void imprimirNomeDaTabela() {
        Class<?> classeProduto = this.getClass();
        if (classeProduto.isAnnotationPresent(Tabela.class)) {
            Annotation tabelaAnnotation = classeProduto.getAnnotation(Tabela.class);
            Tabela tabela = (Tabela) tabelaAnnotation;
            System.out.println("Nome da tabela: " + tabela.nome());
        } else {
            System.out.println("A anotação de tabela não está presente na classe Produto.");
        }
    }
}
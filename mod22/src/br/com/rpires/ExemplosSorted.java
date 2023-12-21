package br.com.rpires;

import java.util.Comparator;
import java.util.List;

/**
 * @author Steve Vaz
 */
public class ExemplosSorted {

    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .sorted(Comparator.comparing(Pessoa::getNome));

        lista.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade));

        lista.stream()
                .sorted((p1,p2) -> Integer.compare(p2.getIdade(), p1.getIdade()));
    }
}

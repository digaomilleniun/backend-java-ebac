package br.com.rpires;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author rodrigo.pires
 */
public class ExemplosFilter {

    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();
        Stream<Pessoa> stream = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"));


        Predicate<Pessoa> pred = pessoa -> pessoa.getNacionalidade().equals("Brasil");
        Stream<Pessoa> stream1 = lista.stream().filter(pred);

        Predicate<Pessoa> pred1 = new Predicate<Pessoa>() {
            @Override
            public boolean test(Pessoa pessoa) {
                return pessoa.getNacionalidade().equals("Brasil");
            }
        };

        Stream<Pessoa> stream2 = lista.stream().filter(pred1);

        Stream<Pessoa> stream3 = lista.stream().filter(new Predicate<Pessoa>() {
            @Override
            public boolean test(Pessoa pessoa) {
                return pessoa.getNacionalidade().equals("Brasil");
            }
        });
    }
}

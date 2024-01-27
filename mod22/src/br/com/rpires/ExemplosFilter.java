package br.com.rpires;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Steve Vaz
 */
public class ExemplosFilter {

    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();
        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"));


        Predicate<Pessoa> pred = pessoa -> pessoa.getNacionalidade().equals("Brasil");
        lista.stream().filter(pred);

        Predicate<Pessoa> pred1 = new Predicate<Pessoa>() {
            @Override
            public boolean test(Pessoa pessoa) {
                return pessoa.getNacionalidade().equals("Brasil");
            }
        };

        lista.stream().filter(pred1);

        lista.stream().filter(new Predicate<Pessoa>() {
            @Override
            public boolean test(Pessoa pessoa) {
                return pessoa.getNacionalidade().equals("Brasil");
            }
        });
    }
}

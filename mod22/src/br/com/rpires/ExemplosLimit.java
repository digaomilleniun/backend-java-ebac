package br.com.rpires;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author rodrigo.pires
 */
public class ExemplosLimit {

    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        Stream<Pessoa> stream = lista.stream().limit(2);
    }
}

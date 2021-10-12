package br.com.rpires;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author rodrigo.pires
 */
public class ExemploDistinct {

    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        Stream<Pessoa> stream = lista.stream().distinct();
    }
}

package br.com.rpires;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author rodrigo.pires
 */
public class ExemplosMap {

    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        Stream<Integer> steam = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .map(Pessoa::getIdade);

        IntStream steam1 = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .mapToInt(Pessoa::getIdade);
    }
}

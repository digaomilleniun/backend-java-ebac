package br.com.rpires;

import java.util.List;

/**
 * @author rodrigo.pires
 */
public class ExemplosCount {

    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        long count = lista.stream()
                .filter(pessoa -> pessoa.getNome().startsWith("M"))
                .count();

        System.out.println(count);
    }
}

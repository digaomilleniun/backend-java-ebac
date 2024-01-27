package br.com.rpires;

import java.util.List;

/**
 * @author Steve Vaz
 */
public class ExemplosMap {

    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .map(Pessoa::getIdade);

        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .mapToInt(Pessoa::getIdade);
    }
}

package br.com.rpires;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author rodrigo.pires
 */
public class ExemplosOPtional {

    public static void main(String[] args, Collection<Pessoa> pessoas) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        Optional<Pessoa> opcional = lista.stream()
                .max(Comparator.comparing(Pessoa::getIdade));

        if (opcional.isPresent()) {
            System.out.println(opcional.get());
        }

        opcional.ifPresent(System.out::println);
        
        Optional<Pessoa> min = pessoas.stream()
        		.min(Comparator.comparing(Pessoa::getIdade));
        min.ifPresentOrElse(System.out::println, new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
        
        });
        
        Pessoa value = min.orElseThrow();
        
        System.out.println(value);
    }
}

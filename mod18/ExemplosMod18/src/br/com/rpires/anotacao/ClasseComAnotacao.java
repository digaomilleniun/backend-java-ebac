package br.com.rpires.anotacao;

/**
 * @author rodrigo.pires
 */
@PrimeiraAnotacao(value = "Rodrigo", bairros = "Teste", numeroCasa = 10)
public class ClasseComAnotacao {

    @PrimeiraAnotacao(value = "Pires", bairros = {"Teste", "Teste1"}, numeroCasa = 20, valores = 100d)
    private String nome;

    @PrimeiraAnotacao(value = "Rodrigo", bairros = "Teste", numeroCasa = 10)
    public ClasseComAnotacao() {

    }
}

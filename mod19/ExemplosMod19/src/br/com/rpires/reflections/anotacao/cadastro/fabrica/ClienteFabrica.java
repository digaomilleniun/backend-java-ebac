package br.com.rpires.reflections.anotacao.cadastro.fabrica;

import br.com.rpires.reflections.anotacao.cadastro.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.domain.Persistente;
import br.com.rpires.reflections.anotacao.cadastro.exception.DadosInvalidosException;

/**
 * @author rodrigo.pires
 *
 * Classe que representa a cricação de objetos Cliente
 *
 */
public class ClienteFabrica implements FabricaPersistente {

    @Override
    public Persistente criarObjeto(String dadosSeparados[]) throws DadosInvalidosException {
        try {
            return new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        } catch(IndexOutOfBoundsException e) {
            throw new DadosInvalidosException("Dados de cliente estão inválidos");
        }

    }
}

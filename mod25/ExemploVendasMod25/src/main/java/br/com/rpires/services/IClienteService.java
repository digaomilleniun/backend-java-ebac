/**
 * 
 */
package br.com.rpires.services;

import br.com.rpires.domain.Cliente_2;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService {

	Boolean cadastrar(Cliente_2 cliente) throws TipoChaveNaoEncontradaException;

	Cliente_2 buscarPorCPF(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente_2 cliente) throws TipoChaveNaoEncontradaException;

}

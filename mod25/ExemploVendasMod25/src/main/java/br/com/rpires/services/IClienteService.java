/**
 * 
 */
package br.com.rpires.services;

import br.com.rpires.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.exception.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService {

	Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

	Cliente buscarPorCPF(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}

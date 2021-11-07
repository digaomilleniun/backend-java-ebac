/**
 * 
 */
package br.com.rpires.services;

import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.exception.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteService implements IClienteService {
	
	private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
		return clienteDAO.cadastrar(cliente);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return clienteDAO.consultar(cpf);
	}

	@Override
	public void excluir(Long cpf) {
		clienteDAO.excluir(cpf);
	}

	@Override
	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
		clienteDAO.alterar(cliente);
	}

}

package br.com.rpires.dao;

import java.util.Collection;

import br.com.rpires.domain.Cliente_2;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoMock implements IClienteDAO2 {

	@Override
	public boolean cadastrar(Cliente_2 entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Long excluir(Long valor) {
		return valor;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente_2 entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente_2 consultar(Long valor) {
		Cliente_2 cliente = new Cliente_2(null, null, null, null, null, null, null);
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente_2> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}


}

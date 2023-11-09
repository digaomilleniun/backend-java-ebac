/**
 * 
 */
package br.com.rpires.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.dao.Persistente;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public abstract class GenericService<T extends Persistente, E extends Serializable> 
	implements IGenericService<T, E> {
	
	@SuppressWarnings("rawtypes")
	protected IClienteDAO dao;
	
	public GenericService(@SuppressWarnings("rawtypes") IClienteDAO clienteDAO) {
		this.dao = clienteDAO;
	}

	@SuppressWarnings("rawtypes")
	public void GenericService11(IClienteDAO clienteDAO) {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
		return this.dao.cadastrar(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void excluir(E valor) {
		this.dao.excluir(valor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void alterar(T entity) throws TipoChaveNaoEncontradaException {
		this.dao.alterar(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T consultar(E valor) {
		return (T) this.dao.consultar(valor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<T> buscarTodos() {
		return this.dao.buscarTodos();
	}

}

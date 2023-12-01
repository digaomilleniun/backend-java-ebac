package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;

import java.util.Collection;

/**
 * @author rodrigo.pires
 *  
 */
public interface IClienteDAO<E> {

    public <T> Boolean cadastrar(T entity);

    public void excluir(E valor);

    public <T> void alterar(T entity);

    public Cliente consultar(E valor);

    public Collection<Cliente> buscarTodos();

	void excluir(Long cpf);

	void alterar(Cliente cliente);

	Cliente consultar(Long cpf);

	Boolean cadastrar(Cliente cliente);
}

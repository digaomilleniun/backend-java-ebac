/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import br.com.rpires.domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO {

	public Cliente cadastrar(Cliente cliente);

	public Cliente buscarPorID(Long id);

	public void excluir(Cliente cliente);

	public Cliente alterar(Cliente cliente);

	public List<Cliente> buscarTodos();
}

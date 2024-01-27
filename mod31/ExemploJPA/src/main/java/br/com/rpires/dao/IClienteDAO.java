/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import br.com.rpires.domain.Cliente_2;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO {

	public Cliente_2 cadastrar(Cliente_2 cliente);

	public Cliente_2 buscarPorID(Long id);

	public void excluir(Cliente_2 cliente);

	public Cliente_2 alterar(Cliente_2 cliente);

	public List<Cliente_2> buscarTodos();
}

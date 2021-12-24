/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO {

	
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;
}

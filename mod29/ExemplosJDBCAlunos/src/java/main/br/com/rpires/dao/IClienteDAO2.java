/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.domain.Cliente_2;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO2 {

	
	public int cadastrar(Cliente_2 cliente) throws Exception;

	public Cliente_2 consultar(String codigo) throws Exception;

	public Integer excluir(Cliente_2 clienteBD) throws Exception;

	void alterar(Object entity);

	void excluir(Long cpf);
}
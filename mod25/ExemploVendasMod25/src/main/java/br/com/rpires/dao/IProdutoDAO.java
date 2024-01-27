/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.dao.generic.IGenericDAO;
import br.com.rpires.domain.Cliente_2;
import br.com.rpires.domain.Produto_4;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoDAO extends IGenericDAO<Produto_4, String>{

	Boolean cadastrar(Cliente_2 cliente) throws TipoChaveNaoEncontradaException;

}

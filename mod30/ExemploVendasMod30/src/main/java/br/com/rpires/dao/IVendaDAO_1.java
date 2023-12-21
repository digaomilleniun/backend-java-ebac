/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.dao.generic.IGenericDAO;
import br.com.rpires.domain.Venda;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO_1 extends IGenericDAO<Venda, String> {

	void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}

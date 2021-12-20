/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.dao.generic.IGenericDAO;
import br.com.rpires.domain.Venda;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}

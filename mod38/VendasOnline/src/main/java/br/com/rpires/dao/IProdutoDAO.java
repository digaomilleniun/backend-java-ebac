/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import br.com.rpires.dao.generic.IGenericDAO;
import br.com.rpires.domain.Produto_4;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoDAO extends IGenericDAO<Produto_4, String>{

	List<Produto_4> filtrarProdutos(String query);

}

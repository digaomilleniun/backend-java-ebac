/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import br.com.rpires.dao.generic.IGenericDAO;
import br.com.rpires.domain.Produto;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}

/**
 * 
 */
package br.com.rpires.service;

import java.util.List;

import br.com.rpires.domain.Produto;
import br.com.rpires.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}

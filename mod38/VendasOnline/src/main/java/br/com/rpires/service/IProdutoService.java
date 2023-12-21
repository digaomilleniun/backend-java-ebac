/**
 * 
 */
package br.com.rpires.service;

import java.util.List;

import br.com.rpires.domain.Produto_4;
import br.com.rpires.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoService extends IGenericService<Produto_4, String> {

	List<Produto_4> filtrarProdutos(String query);

}

/**
 * 
 */
package br.com.rpires.services;

import br.com.rpires.dao.IProdutoDAO_1;
import br.com.rpires.domain.Produto_4;
import br.com.rpires.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto_4, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO_1 dao) {
		super(dao);
	}

}

/**
 * 
 */
package br.com.rpires.services;

import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.domain.Produto;
import br.com.rpires.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}

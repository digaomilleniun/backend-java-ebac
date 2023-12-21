/**
 * 
 */
package br.com.rpires.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.rpires.dao.IProdutoDAO_1;
import br.com.rpires.domain.Produto_4;
import br.com.rpires.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class ProdutoService extends GenericService<Produto_4, String> implements IProdutoService {
	
	private IProdutoDAO_1 produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO_1 produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto_4> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}

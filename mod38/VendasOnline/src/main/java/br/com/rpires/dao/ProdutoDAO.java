/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Produto_4;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoDAO extends GenericDAO<Produto_4, String> implements IProdutoDAO_1 {

	public ProdutoDAO() {
		super(Produto_4.class);
	}

	@Override
	public List<Produto_4> filtrarProdutos(String query) {
		TypedQuery<Produto_4> tpQuery =
				this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}

}

/**
 * 
 */
package br.com.rpires.dao.jpa;

import br.com.rpires.dao.generic.jpa.GenericJpaDAO;
import br.com.rpires.domain.jpa.ProdutoJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}

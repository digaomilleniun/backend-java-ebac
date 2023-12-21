/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Cliente_2;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAO extends GenericDAO<Cliente_2, Long> implements IClientDAO {

	public ClienteDAO() {
		super(Cliente_2.class);
	}

	@Override
	public List<Cliente_2> filtrarClientes(String query) {
		TypedQuery<Cliente_2> tpQuery =
				this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
		
	}

}

/**
 * 
 */
package br.com.rpires.dao.jpa;

import br.com.rpires.dao.generic.jpa.GenericJpaDAO;
import br.com.rpires.domain.jpa.ClienteJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}

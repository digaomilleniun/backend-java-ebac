/**
 * 
 */
package br.com.rpires.dao;

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

}

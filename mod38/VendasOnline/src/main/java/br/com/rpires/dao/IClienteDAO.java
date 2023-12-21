/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import br.com.rpires.dao.generic.IGenericDAO;
import br.com.rpires.domain.Cliente_2;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO extends IGenericDAO<Cliente_2, Long>{

	List<Cliente_2> filtrarClientes(String query);

}

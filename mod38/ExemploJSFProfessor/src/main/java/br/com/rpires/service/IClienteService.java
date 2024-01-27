/**
 * 
 */
package br.com.rpires.service;

import br.com.rpires.domain.Cliente_2;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericService<Cliente_2, Long> {

	Cliente_2 buscarPorCPF(Long cpf) throws DAOException;

}

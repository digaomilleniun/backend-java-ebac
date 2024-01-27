/**
 * 
 */
package br.com.rpires.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.rpires.dao.IClienteDAO2;
import br.com.rpires.domain.Cliente_2;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class ClienteService extends GenericService<Cliente_2, Long> implements IClienteService {
	
	@Inject
	public ClienteService(IClienteDAO2 clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente_2 buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

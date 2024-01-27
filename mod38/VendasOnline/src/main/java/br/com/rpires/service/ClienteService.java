/**
 * 
 */
package br.com.rpires.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.rpires.dao.IClientDAO;
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
	
	private IClientDAO clienteDAO;
	
	@Inject
	public ClienteService(IClientDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
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

	@Override
	public List<Cliente_2> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}

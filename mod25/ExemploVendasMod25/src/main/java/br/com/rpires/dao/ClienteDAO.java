/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.dao.generic.GenericDAO;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

	public ClienteDAO() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		// TODO Auto-generated method stub
		return Cliente.class;
	}

	@Override
	public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
		// TODO Auto-generated method stub
		
	}



}

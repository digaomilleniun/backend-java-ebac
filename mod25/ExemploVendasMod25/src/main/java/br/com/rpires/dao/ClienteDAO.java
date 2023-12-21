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

public class ClienteDAO<T extends Persistence, E> extends GenericDAO<T, E> implements IClienteDAO2, IClientDAO {

	public ClienteDAO() {
		super();
	}

	@Override
	public Class<Cliente_2> getTipoClasse() {
		return Cliente_2.class;
	}

	@Override
	public void atualiarDados(Cliente_2 entity, Cliente_2 entityCadastrado) {
		entityCadastrado.setCidade(entity.getCidade());
		entityCadastrado.setCpf(entity.getCpf());
		entityCadastrado.setEnd(entity.getEnd());
		entityCadastrado.setEstado(entity.getEstado());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setNumero(entity.getNumero());
		entityCadastrado.setTel(entity.getTel());
		
	}


	@Override
	public Integer excluir(Object valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Long cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente_2 cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente_2 consultar(Long cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualiarDados(T entity, T entityCadastrado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer cadastrar(Cliente_2 cliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente_2 consultar(Object valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean cadastrar(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(long parseLong) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Object entity) {
		// TODO Auto-generated method stub
		
	}
}

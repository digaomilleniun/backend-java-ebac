/**
 * 
 */
package br.com.rpires.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Cliente_2;
import br.com.rpires.domain.Produto;
import br.com.rpires.domain.Produto_4;

/**
 * @author rodrigo.pires
 *
 */

public class ClienteDAO<T extends Persistence, E> extends GenericDAO<T, E> implements IClienteDAO2, IClientDAO {

	public ClienteDAO() {
		super();
	}

	@Override
	public Class<Produto> getTipoClasse() {
		return Cliente_2.class;
	}

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

	@Override
	public Cliente_2 consultar(String codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer excluir(Cliente_2 clienteBD) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getQueryInsercao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente_2 entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getQueryExclusao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getQueryAtualizacao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto_4 entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente_2 entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}

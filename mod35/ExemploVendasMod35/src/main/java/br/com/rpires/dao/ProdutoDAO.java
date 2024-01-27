/**
 * 
 */
package br.com.rpires.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Cliente_2;
import br.com.rpires.domain.Produto_4;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoDAO extends GenericDAO<Produto_4, String> implements IProdutoDAO_1 {
	
	public ProdutoDAO() {
		super();
	}

	@Override
	public Class<Cliente_2> getTipoClasse() {
		return Produto_4.class;
	}

	@Override
	public void atualiarDados(Produto_4 entity, Produto_4 entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setDescricao(entity.getDescricao());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setValor(entity.getValor());
	}

	@Override
	protected String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_PRODUTO ");
		sb.append("(ID, CODIGO, NOME, DESCRICAO, VALOR)");
		sb.append("VALUES (nextval('sq_produto'),?,?,?,?)");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto_4 entity) throws SQLException {
		stmInsert.setString(1, entity.getCodigo());
		stmInsert.setString(2, entity.getNome());
		stmInsert.setString(3, entity.getDescricao());
		stmInsert.setBigDecimal(4, entity.getValor());
	}

	@Override
	protected String getQueryExclusao() {
		return "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {
		stmExclusao.setString(1, valor);
	}

	@Override
	protected String getQueryAtualizacao() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE TB_PRODUTO ");
		sb.append("SET CODIGO = ?,");
		sb.append("NOME = ?,");
		sb.append("DESCRICAO = ?,");
		sb.append("VALOR = ?");
		sb.append("WHERE CODIGO = ? ");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto_4 entity) throws SQLException {
		stmUpdate.setString(1, entity.getCodigo());
		stmUpdate.setString(2, entity.getNome());
		stmUpdate.setString(3, entity.getDescricao());
		stmUpdate.setBigDecimal(4, entity.getValor());
		stmUpdate.setString(5, entity.getCodigo());
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {
		stmExclusao.setString(1, valor);
	}

}

/**
 * 
 */
package br.com.rpires.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.rpires.dao.factory.ProdutoQuantidadeFactory;
import br.com.rpires.dao.factory.VendaFactory;
import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.ProdutoQuantidade;
import br.com.rpires.domain.Venda;
import br.com.rpires.domain.Venda.Status;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {
	

	@Override
	public Class<Venda> getTipoClasse() {
		return Venda.class;
	}

	@Override
	public void atualiarDados(Venda entity, Venda entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setStatus(entity.getStatus());
	}

	@Override
	public void excluir(String valor) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		
		Connection connection = null;
    	PreparedStatement stm = null;
    	try {
    		String sql = "UPDATE TB_VENDA SET STATUS_VENDA = ? WHERE ID = ?";
    		connection = getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, Status.CONCLUIDA.name());
			stm.setLong(2, venda.getId());
			stm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DAOException("ERRO ATUALIZANDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
	}
	
	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		Connection connection = null;
    	PreparedStatement stm = null;
    	try {
    		String sql = "UPDATE TB_VENDA SET STATUS_VENDA = ? WHERE ID = ?";
    		connection = getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, Status.CANCELADA.name());
			stm.setLong(2, venda.getId());
			stm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DAOException("ERRO ATUALIZANDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
	}

	@Override
	protected String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_VENDA ");
		sb.append("(ID, CODIGO, ID_CLIENTE_FK, VALOR_TOTAL, DATA_VENDA, STATUS_VENDA)");
		sb.append("VALUES (nextval('sq_venda'),?,?,?,?,?)");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Venda entity) throws SQLException {
		stmInsert.setString(1, entity.getCodigo());
		stmInsert.setLong(2, entity.getCliente().getId());
		stmInsert.setBigDecimal(3, entity.getValorTotal());
		stmInsert.setTimestamp(4, Timestamp.from(entity.getDataVenda()));
		stmInsert.setString(5, entity.getStatus().name());
	}

	@Override
	protected String getQueryExclusao() {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmInsert, String valor) throws SQLException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	protected String getQueryAtualizacao() {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Venda entity) throws SQLException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stm, String valor) throws SQLException {
		stm.setString(1, valor);
	}
	
	

	@Override
	public Venda consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException {
		//TODO pode ser feito desta forma
//		Venda venda = super.consultar(valor);
//		Cliente cliente = clienteDAO.consultar(venda.getCliente().getId());
//		venda.setCliente(cliente);
//		return venda;
		
		//TODO Ou pode ser feito com join
		StringBuilder sb = sqlBaseSelect();
		sb.append("WHERE V.CODIGO = ? ");
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
    		//validarMaisDeUmRegistro();
    		connection = getConnection();
			stm = connection.prepareStatement(sb.toString());
			setParametrosQuerySelect(stm, valor);
			rs = stm.executeQuery();
		    if (rs.next()) {
		    	Venda venda = VendaFactory.convert(rs);
		    	buscarAssociacaoVendaProdutos(connection, venda);
		    	return venda;
		    }
		    
		} catch (SQLException e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, rs);
		}
    	return null;
		
	}

	private void buscarAssociacaoVendaProdutos(Connection connection, Venda venda)
			throws DAOException {
		PreparedStatement stmProd = null;
		ResultSet rsProd = null;
		try {
			StringBuilder sbProd = new StringBuilder();
		    sbProd.append("SELECT PQ.ID, PQ.QUANTIDADE, PQ.VALOR_TOTAL, ");
		    sbProd.append("P.ID AS ID_PRODUTO, P.CODIGO, P.NOME, P.DESCRICAO, P.VALOR ");
		    sbProd.append("FROM TB_PRODUTO_QUANTIDADE PQ ");
		    sbProd.append("INNER JOIN TB_PRODUTO P ON P.ID = PQ.ID_PRODUTO_FK ");
		    sbProd.append("WHERE PQ.ID_VENDA_FK = ?");
		    stmProd = connection.prepareStatement(sbProd.toString());
		    stmProd.setLong(1, venda.getId());
		    rsProd = stmProd.executeQuery();
		    Set<ProdutoQuantidade> produtos = new HashSet<>();
		    while(rsProd.next()) {
		    	ProdutoQuantidade prodQ = ProdutoQuantidadeFactory.convert(rsProd);
		    	produtos.add(prodQ);
		    }
		    venda.setProdutos(produtos);
		    venda.recalcularValorTotalVenda();
		} catch (SQLException e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
		} finally {
			closeConnection(connection, stmProd, rsProd);
		}
	}
	
	

	@Override
	public Collection<Venda> buscarTodos() throws DAOException {
		List<Venda> lista = new ArrayList<>();
		StringBuilder sb = sqlBaseSelect();
		
		try {
    		Connection connection = getConnection();
			PreparedStatement stm = connection.prepareStatement(sb.toString());
			ResultSet rs = stm.executeQuery();
		    while (rs.next()) {
		    	Venda venda = VendaFactory.convert(rs);
		    	buscarAssociacaoVendaProdutos(connection, venda);
		    	lista.add(venda);
		    }
		    
		} catch (SQLException e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
		} 
    	return lista;
	}

	private StringBuilder sqlBaseSelect() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT V.ID AS ID_VENDA, V.CODIGO, V.VALOR_TOTAL, V.DATA_VENDA, V.STATUS_VENDA, ");
		sb.append("C.ID AS ID_CLIENTE, C.NOME, C.CPF, C.TEL, C.ENDERECO, C.NUMERO, C.CIDADE, C.ESTADO ");
		sb.append("FROM TB_VENDA V ");
		sb.append("INNER JOIN TB_CLIENTE C ON V.ID_CLIENTE_FK = C.ID ");
		return sb;
	}

	@Override
	public Boolean cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		Connection connection = null;
    	PreparedStatement stm = null;
    	try {
    		connection = getConnection();
			stm = connection.prepareStatement(getQueryInsercao(), Statement.RETURN_GENERATED_KEYS);
			setParametrosQueryInsercao(stm, entity);
			int rowsAffected = stm.executeUpdate();

			if(rowsAffected > 0) {
				try (ResultSet rs = stm.getGeneratedKeys()){
					if (rs.next()) {
						entity.setId(rs.getLong(1));
					}
				}
				
				for (ProdutoQuantidade prod : entity.getProdutos()) {
					stm = connection.prepareStatement(getQueryInsercaoProdQuant());
					setParametrosQueryInsercaoProdQuant(stm, entity, prod);
					rowsAffected = stm.executeUpdate();
				}
				
				
				return true;
			}
			
		} catch (SQLException e) {
			throw new DAOException("ERRO CADASTRANDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
		return false;
	}

	private String getQueryInsercaoProdQuant() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_PRODUTO_QUANTIDADE ");
		sb.append("(ID, ID_PRODUTO_FK, ID_VENDA_FK, QUANTIDADE, VALOR_TOTAL)");
		sb.append("VALUES (nextval('sq_produto_quantidade'),?,?,?,?)");
		return sb.toString();
	}
	
	private void setParametrosQueryInsercaoProdQuant(PreparedStatement stm, Venda venda, ProdutoQuantidade prod) throws SQLException {
		stm.setLong(1, prod.getProduto().getId());
		stm.setLong(2, venda.getId());
		stm.setInt(3, prod.getQuantidade());
		stm.setBigDecimal(4, prod.getValorTotal());
	}

}

/**
 * 
 */
package br.com.rpires.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.rpires.dao.jdbc.ConnectionFactory;
import br.com.rpires.domain.Cliente_2;

/**
 * @author rodrigo.pires
 *
 */
public abstract class ClienteDAO1 implements IClienteDAO2 {

	public int cadastrar(Cliente_2 cliente) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_CLIENTE_2 (ID, CODIGO, NOME) VALUES (nextval('SQ_CLIENTE_2'),?,?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	public Cliente_2 consultar(String codigo) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente_2 cliente = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from vendas_online_2 where codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next()) {
				cliente = new Cliente_2();
				cliente.setId(rs.getLong("id"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNome(rs.getString("nome"));
			}
			return cliente;
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	public Integer excluir(Cliente_2 cliente) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM TB_CLIENTE_2 WHERE CODIGO = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

}

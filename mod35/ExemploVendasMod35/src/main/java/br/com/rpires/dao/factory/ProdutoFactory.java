/**
 * 
 */
package br.com.rpires.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.rpires.domain.Produto_4;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoFactory {

	
	public static Produto_4 convert(ResultSet rs) throws SQLException {
		Produto_4 prod = new Produto_4();
		prod.setId(rs.getLong("ID_PRODUTO"));
		prod.setCodigo(rs.getString("CODIGO"));
		prod.setNome(rs.getString("NOME"));
		prod.setDescricao(rs.getString("DESCRICAO"));
		prod.setValor(rs.getBigDecimal("VALOR"));
		return prod;
	}
}

/**
 * 
 */
package br.com.rpires.dao;

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

}

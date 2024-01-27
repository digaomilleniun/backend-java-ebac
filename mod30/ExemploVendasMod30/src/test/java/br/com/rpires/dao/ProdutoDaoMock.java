/**
 * 
 */
package br.com.rpires.dao;

import java.util.Collection;

import br.com.rpires.domain.Produto_4;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoDaoMock implements IProdutoDAO_1 {

	@Override
	public Boolean cadastrar(Produto_4 entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void excluir(String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Produto_4 entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto_4 consultar(String valor) {
		Produto_4 produto = new Produto_4();
		produto.setCodigo(valor);
		return produto;
	}

	@Override
	public Collection<Produto_4> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}

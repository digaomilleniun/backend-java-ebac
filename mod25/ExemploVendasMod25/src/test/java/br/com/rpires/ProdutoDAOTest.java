/**
 * 
 */
package br.com.rpires;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rpires.dao.IProdutoDAO_1;
import br.com.rpires.dao.ProdutoDAO_3;
import br.com.rpires.domain.Produto_4;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoDAOTest {
	
	private IProdutoDAO_1 produtoDao;

	private Produto_4 produto;
	
	public ProdutoDAOTest() {
		produtoDao = new ProdutoDAO_3();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		produto = new Produto_4();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produtoDao.cadastrar(produto);
	}
	
	@Test
	public void pesquisar() {
		Produto_4 produto = this.produtoDao.consultar(this.produto.getCodigo());
		Assert.assertNotNull(produto);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException {
		produto.setCodigo("A2");
		Boolean retorno = produtoDao.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() {
		produtoDao.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		produto.setNome("Rodrigo Pires");
		produtoDao.alterar(produto);
		
		Assert.assertEquals("Rodrigo Pires", produto.getNome());
	}
	
	@Test
	public void buscarTodos() {
		Collection<Produto_4> list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
}

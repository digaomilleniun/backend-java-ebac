/**
 * 
 */
package br.com.rpires;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.dao.ProdutoDAO;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoDAOTest {
	
	private IProdutoDAO produtoDao;

	public ProdutoDAOTest() {
		produtoDao = new ProdutoDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Produto> list = produtoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				produtoDao.excluir(prod.getCodigo());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produtoDao.cadastrar(produto);
		return produto;
	}
	
	private void excluir(String valor) throws DAOException {
		this.produtoDao.excluir(valor);
	}
	
	@Test
	public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		Produto produto = criarProduto("A1");
		Assert.assertNotNull(produto);
		Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
		Assert.assertNotNull(produtoDB);
		excluir(produtoDB.getCodigo());
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Produto produto = criarProduto("A2");
		Assert.assertNotNull(produto);
		excluir(produto.getCodigo());
	}
	
	@Test
	public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A3");
		Assert.assertNotNull(produto);
		excluir(produto.getCodigo());
		Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
		assertNull(produtoBD);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A4");
		produto.setNome("Rodrigo Pires");
		produtoDao.alterar(produto);
		Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		Assert.assertEquals("Rodrigo Pires", produtoBD.getNome());
		
		excluir(produto.getCodigo());
		Produto produtoBD1 = this.produtoDao.consultar(produto.getCodigo());
		assertNull(produtoBD1);
	}
	
	@Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<Produto> list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		for (Produto prod : list) {
			excluir(prod.getCodigo());
		}
		
		list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
		
	}
}

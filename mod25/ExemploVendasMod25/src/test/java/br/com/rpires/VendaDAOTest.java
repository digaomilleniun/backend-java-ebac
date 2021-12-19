/**
 * 
 */
package br.com.rpires;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.Instant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rpires.dao.ClienteDAO;
import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.dao.IVendaDAO;
import br.com.rpires.dao.ProdutoDAO;
import br.com.rpires.dao.VendaDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;
import br.com.rpires.domain.Venda;
import br.com.rpires.domain.Venda.Status;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class VendaDAOTest {
	
	private IVendaDAO vendaDao;
	
	private IClienteDAO clienteDao;
	
	private IProdutoDAO produtoDao;

	private Venda venda;
	
	private Cliente cliente;
	
	private Produto produto;
	
	public VendaDAOTest() {
		vendaDao = new VendaDAO();
		clienteDao = new ClienteDAO();
		produtoDao = new ProdutoDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		cadastrarCliente();
		cadastrarProduto();
		venda = new Venda();
		venda.setCodigo("A1");
		venda.setDataVenda(Instant.now());
		venda.setCliente(this.cliente);
		venda.setStatus(Status.CONCLUIDA);
		venda.adicionarProduto(this.produto, 2);
		this.vendaDao.cadastrar(venda);
	}
	
	@Test
	public void pesquisar() {
		Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
		Assert.assertNotNull(vendaConsultada);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException {
		venda.setCodigo("A2");
		Boolean retorno = vendaDao.cadastrar(venda);
		assertTrue(retorno);
		assertTrue(this.venda.getValorTotal().equals(BigDecimal.valueOf(20)));
	} 
	
	@Test
	public void cancelarVenda() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A3";
		venda.setStatus(Status.CANCELADA);
		venda.setCodigo(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);
		
		assertTrue(retorno);
		
		vendaDao.alterar(this.venda);
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		
		assertEquals(codigoVenda, vendaConsultada.getCodigo());
		assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
	}

	private void cadastrarProduto() throws TipoChaveNaoEncontradaException {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produtoDao.cadastrar(produto);
	}

	private void cadastrarCliente() throws TipoChaveNaoEncontradaException {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		clienteDao.cadastrar(cliente);
	}

}

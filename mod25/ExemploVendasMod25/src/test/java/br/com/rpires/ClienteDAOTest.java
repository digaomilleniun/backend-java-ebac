/**
 * 
 */
package br.com.rpires;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rpires.dao.ClienteDAO1;
import br.com.rpires.dao.IClienteDAO2;
import br.com.rpires.domain.Cliente_2;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAOTest {
	
	private IClienteDAO2 clienteDao;

	private Cliente_2 cliente;
	
	public ClienteDAOTest() {
		clienteDao = (IClienteDAO2) new ClienteDAO1();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		cliente = new Cliente_2(null, null, null, null, null, null, null);
		cliente.setCpf(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		try {
			clienteDao.cadastrar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void pesquisarCliente() throws Exception {
		Cliente_2 clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws Exception {
		cliente.setCpf(56565656565L);
		boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertFalse(retorno);
	}
	
	
	@Test
	public void excluirCliente() {
		try {
			clienteDao.excluir(cliente.getCpf());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Rodrigo Pires");
		clienteDao.alterar(cliente);
		Assert.assertEquals("Rodrigo Pires", cliente.getNome());
	}
	
	@Test
	public void buscarTodos() {
		Collection<Cliente_2> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
}

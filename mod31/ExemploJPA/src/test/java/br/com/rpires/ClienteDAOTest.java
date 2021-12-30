/**
 * 
 */
package br.com.rpires;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.com.rpires.dao.ClienteDAO;
import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAOTest {
	
	IClienteDAO clienteDAO;
	
	public ClienteDAOTest() {
		clienteDAO = new ClienteDAO();
	}
	
	@After
	public void end() {
		List<Cliente> list = clienteDAO.buscarTodos();
		list.forEach(cli -> clienteDAO.excluir(cli));
	}

	@Test
	public void cadastrar() {
		Cliente cliente = criarCliente();
		assertNotNull(cliente);
		
		Cliente clienteDB = clienteDAO.buscarPorID(cliente.getId());
		assertNotNull(clienteDB);
		assertEquals(cliente.getId(), clienteDB.getId());
		assertEquals(cliente.getNome(), clienteDB.getNome());
		
//		clienteDAO.excluir(cliente);
//		Cliente clienteDBEx = clienteDAO.buscarPorID(cliente.getId());
//		assertNull(clienteDBEx);
	}

	@Test
	public void alterar() {
		Cliente cliente = criarCliente();
		assertNotNull(cliente);
		
		Cliente clienteDB = clienteDAO.buscarPorID(cliente.getId());
		assertNotNull(clienteDB);
		assertEquals(cliente.getId(), clienteDB.getId());
		assertEquals(cliente.getNome(), clienteDB.getNome());
		
		clienteDB.setNome("Rodrigo Pires");
		Cliente clienteUp = clienteDAO.alterar(clienteDB);
		assertEquals("Rodrigo Pires", clienteUp.getNome());
		
//		clienteDAO.excluir(cliente);
//		Cliente clienteDBEx = clienteDAO.buscarPorID(cliente.getId());
//		assertNull(clienteDBEx);
		
	}
	
	private Cliente criarCliente() {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente = clienteDAO.cadastrar(cliente);	
		return cliente;
	}
}

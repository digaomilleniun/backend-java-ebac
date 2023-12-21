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
import br.com.rpires.dao.IClientDAO;
import br.com.rpires.domain.Cliente_2;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAOTest {
	
	IClientDAO clienteDAO;
	
	public ClienteDAOTest() {
		clienteDAO = new ClienteDAO();
	}
	
	@After
	public void end() {
		List<Cliente_2> list = clienteDAO.buscarTodos();
		list.forEach(cli -> clienteDAO.excluir(cli));
	}

	@Test
	public void cadastrar() {
		Cliente_2 cliente = criarCliente();
		assertNotNull(cliente);
		
		Cliente_2 clienteDB = clienteDAO.buscarPorID(cliente.getId());
		assertNotNull(clienteDB);
		assertEquals(cliente.getId(), clienteDB.getId());
		assertEquals(cliente.getNome(), clienteDB.getNome());
		
//		clienteDAO.excluir(cliente);
//		Cliente clienteDBEx = clienteDAO.buscarPorID(cliente.getId());
//		assertNull(clienteDBEx);
	}

	@Test
	public void alterar() {
		Cliente_2 cliente = criarCliente();
		assertNotNull(cliente);
		
		Cliente_2 clienteDB = clienteDAO.buscarPorID(cliente.getId());
		assertNotNull(clienteDB);
		assertEquals(cliente.getId(), clienteDB.getId());
		assertEquals(cliente.getNome(), clienteDB.getNome());
		
		clienteDB.setNome("Rodrigo Pires");
		Cliente_2 clienteUp = clienteDAO.alterar(clienteDB);
		assertEquals("Rodrigo Pires", clienteUp.getNome());
		
//		clienteDAO.excluir(cliente);
//		Cliente clienteDBEx = clienteDAO.buscarPorID(cliente.getId());
//		assertNull(clienteDBEx);
		
	}
	
	private Cliente_2 criarCliente() {
		Cliente_2 cliente = new Cliente_2();
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

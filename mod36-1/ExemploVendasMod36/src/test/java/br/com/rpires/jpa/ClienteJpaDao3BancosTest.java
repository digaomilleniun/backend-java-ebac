/**
 * 
 */
package br.com.rpires.jpa;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.rpires.dao.jpa.ClienteJpaDAO;
import br.com.rpires.dao.jpa.ClienteJpaDB2DAO;
import br.com.rpires.dao.jpa.ClienteJpaDB3DAO;
import br.com.rpires.dao.jpa.IClienteJpaDAO;
import br.com.rpires.domain.jpa.ClienteJpa;
import br.com.rpires.domain.jpa.ClienteJpa2;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDao3BancosTest {
	
	private IClienteJpaDAO<ClienteJpa> clienteDao;
	
	private IClienteJpaDAO<ClienteJpa> clienteDB2Dao;
	
	private IClienteJpaDAO<ClienteJpa2> clienteDB3Dao;
	
	private Random rd;
	
	public ClienteJpaDao3BancosTest() {
		this.clienteDao = new ClienteJpaDAO();
		this.clienteDB2Dao = new ClienteJpaDB2DAO();
		this.clienteDB3Dao = new ClienteJpaDB3DAO();
		rd = new Random();
	}
	
	@After
	public void end() throws DAOException {
		Collection<ClienteJpa> list = clienteDao.buscarTodos();
		excluir(list, clienteDao);
		
		Collection<ClienteJpa> list2 = clienteDB2Dao.buscarTodos();
		excluir(list2, clienteDB2Dao);
		
		Collection<ClienteJpa2> list3 = clienteDB3Dao.buscarTodos();
		excluir3(list3);
	}
	
	private void excluir(Collection<ClienteJpa> list, IClienteJpaDAO<ClienteJpa> clienteDao) {
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	private void excluir3(Collection<ClienteJpa2> list) {
		list.forEach(cli -> {
			try {
				clienteDB3Dao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ClienteJpa cliente = criarCliente();
		clienteDao.cadastrar(cliente);
		
		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		cliente.setId(null);
		clienteDB2Dao.cadastrar(cliente);
		
		ClienteJpa clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado2);
		
		ClienteJpa2 cliente2 = criarCliente2();
		clienteDB3Dao.cadastrar(cliente2);
		
		ClienteJpa2 clienteConsultado3 = clienteDB3Dao.consultar(cliente2.getId());
		Assert.assertNotNull(clienteConsultado3);
		
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa clienteConsultado = clienteDao.consultar(retorno.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		
		ClienteJpa clienteConsultado1 = clienteDao.consultar(retorno.getId());
		Assert.assertNull(clienteConsultado1);
	}
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Rodrigo Pires");
		clienteDao.alterar(clienteConsultado);
		
		ClienteJpa clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJpa cliente = criarCliente();
		ClienteJpa retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClienteJpa cliente1 = criarCliente();
		ClienteJpa retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertNotNull(retorno1);
		
		Collection<ClienteJpa> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<ClienteJpa> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
	
	private ClienteJpa criarCliente() {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}
	
	private ClienteJpa2 criarCliente2() {
		ClienteJpa2 cliente = new ClienteJpa2();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}

}

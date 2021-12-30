/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rpires.domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAO implements IClienteDAO {
	
	@Override
	public Cliente cadastrar(Cliente cliente) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		return cliente;
	}

	@Override
	public Cliente buscarPorID(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Cliente cliente = entityManager.find(Cliente.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return cliente;
	}

	@Override
	public void excluir(Cliente cliente) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		cliente = entityManager.merge(cliente);
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public Cliente alterar(Cliente cliente) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		cliente = entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		List<Cliente> list = 
				entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();      
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}

}

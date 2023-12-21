/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rpires.domain.Cliente_2;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAO implements IClientDAO {
	
	@Override
	public Cliente_2 cadastrar(Cliente_2 cliente) {
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
	public Cliente_2 buscarPorID(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Cliente_2 cliente = entityManager.find(Cliente_2.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return cliente;
	}

	@Override
	public void excluir(Cliente_2 cliente) {
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
	public Cliente_2 alterar(Cliente_2 cliente) {
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
	public List<Cliente_2> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		List<Cliente_2> list =
				entityManager.createQuery("SELECT c FROM Cliente c", Cliente_2.class).getResultList();
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return list;
	}

}

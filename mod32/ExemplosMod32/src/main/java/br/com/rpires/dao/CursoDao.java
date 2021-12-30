/**
 * 
 */
package br.com.rpires.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rpires.domain.Curso;

/**
 * @author rodrigo.pires
 *
 */
public class CursoDao implements ICursoDao {

	@Override
	public Curso cadastrar(Curso curso) {
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(curso);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		
		return curso;
	}

}

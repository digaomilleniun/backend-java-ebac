/**
 * 
 */
package br.com.rpires.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rpires.domain.Aluno1;

/**
 * @author rodrigo.pires
 *
 */
public class AlunoDao implements IAlunoDao{

	@Override
	public Aluno1 cadastrar(Aluno1 aluno) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(aluno);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		
		return aluno;
	}

}

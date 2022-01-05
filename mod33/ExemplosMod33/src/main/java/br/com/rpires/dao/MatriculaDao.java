/**
 * 
 */
package br.com.rpires.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.rpires.domain.Curso;
import br.com.rpires.domain.Matricula;

/**
 * @author rodrigo.pires
 *
 */
public class MatriculaDao implements IMatriculaDao {

	@Override
	public Matricula cadastrar(Matricula mat) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(mat);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		return mat;
	}

	@Override
	public Matricula buscarPorCodigoCurso(String codigoCurso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT m FROM Matricula m ");
		sb.append("INNER JOIN Curso c on c = m.curso ");
		sb.append("WHERE c.codigo = :codigoCurso");
		
		entityManager.getTransaction().begin();
		TypedQuery<Matricula> query = 
				entityManager.createQuery(sb.toString(), Matricula.class);
		query.setParameter("codigoCurso", codigoCurso);
		Matricula matricula = query.getSingleResult();    
		
		entityManager.close();
		entityManagerFactory.close();
		
		return matricula;
	}

	@Override
	public Matricula buscarPorCurso(Curso curso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT m FROM Matricula m ");
		sb.append("INNER JOIN Curso c on c = m.curso ");
		sb.append("WHERE c = :curso");
		
		entityManager.getTransaction().begin();
		TypedQuery<Matricula> query = 
				entityManager.createQuery(sb.toString(), Matricula.class);
		query.setParameter("curso", curso);
		Matricula matricula = query.getSingleResult();    
		
		entityManager.close();
		entityManagerFactory.close();
		
		return matricula;
	}
	
	@Override
	public Matricula buscarPorCodigoCursoCriteria(String codigoCurso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
		Root<Matricula> root = query.from(Matricula.class);
		Join<Object, Object> join = root.join("curso", JoinType.INNER);
		query.select(root).where(builder.equal(join.get("codigo"), codigoCurso));
		
		TypedQuery<Matricula> tpQuery = 
				entityManager.createQuery(query);
		Matricula matricula = tpQuery.getSingleResult();    
		
		entityManager.close();
		entityManagerFactory.close();
		
		return matricula;
	}

	@Override
	public Matricula buscarPorCursoCriteria(Curso curso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
		Root<Matricula> root = query.from(Matricula.class);
		Join<Object, Object> join = root.join("curso", JoinType.INNER);
		query.select(root).where(builder.equal(join, curso));
		
		TypedQuery<Matricula> tpQuery = 
				entityManager.createQuery(query);
		Matricula matricula = tpQuery.getSingleResult();    
		
		entityManager.close();
		entityManagerFactory.close();
		
		return matricula;
	}

}

/**
 * 
 */
package br.com.rpires.dao;

import java.util.Arrays;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import br.com.rpires.domain.Curso;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

/**
 * @author rodrigo.pires
 *
 */
public class CursoDao implements ICursoDao {

	@Override
	public Curso cadastrar(Curso curso) {
		MongoCredential credential = MongoCredential.createCredential("teste", "ebac", "teste".toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017), Arrays.asList(credential));
		Morphia morphia = new Morphia();
        morphia.mapPackage("br.com.rpires.domain");
        Datastore datastore = morphia.createDatastore(mongoClient, "ebac");
        datastore.ensureIndexes();
        //datastore.save(curso.getMatriculas());
        datastore.save(curso);
		
		
//		EntityManagerFactory entityManagerFactory = 
//				Persistence.createEntityManagerFactory("ExemploJPA");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(curso);
//		entityManager.getTransaction().commit();
//		 
//		entityManager.close();
//		entityManagerFactory.close();
		
		
		return curso;
	}

	@Override
	public void excluir(Curso cur) {
//		EntityManagerFactory entityManagerFactory = 
//				Persistence.createEntityManagerFactory("ExemploJPA");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		entityManager.getTransaction().begin();
//		cur = entityManager.merge(cur);
//		entityManager.remove(cur);
//		entityManager.getTransaction().commit();
//		 
//		entityManager.close();
//		entityManagerFactory.close();
		
	}

	@Override
	public List<Curso> buscarTodos() {
//		EntityManagerFactory entityManagerFactory = 
//				Persistence.createEntityManagerFactory("ExemploJPA");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Curso> query = builder.createQuery(Curso.class);
//		Root<Curso> root = query.from(Curso.class);
//		query.select(root);
//		
//		TypedQuery<Curso> tpQuery = 
//				entityManager.createQuery(query);
//		List<Curso> list = tpQuery.getResultList();  
//		
//		entityManager.close();
//		entityManagerFactory.close();
//		return list;
		return null;
	}

}

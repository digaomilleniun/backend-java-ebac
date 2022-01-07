/**
 * 
 */
package br.com.rpires.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.rpires.domain.Curso;

/**
 * @author rodrigo.pires
 *
 */
public interface ICursoRepository extends MongoRepository<Curso, String>{

}

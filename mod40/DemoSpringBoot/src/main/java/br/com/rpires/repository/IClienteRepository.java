/**
 * 
 */
package br.com.rpires.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rpires.domain.Cliente_2;

/**
 * @author rodrigo.pires
 *
 */
@Repository
public interface IClienteRepository extends CrudRepository<Cliente_2, Long>{

}

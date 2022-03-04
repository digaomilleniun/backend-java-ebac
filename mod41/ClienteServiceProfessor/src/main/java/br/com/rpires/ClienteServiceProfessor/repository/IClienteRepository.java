/**
 * 
 */
package br.com.rpires.ClienteServiceProfessor.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.rpires.ClienteServiceProfessor.domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String>{

	Optional<Cliente> findByCpf(Long cpf);
}

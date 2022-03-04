/**
 * 
 */
package br.com.rpires.ProfessorServiceProfessor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author rodrigo.pires
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.rpires.ProdutoServiceProfessor.repository")
public class MongoConfig {

}

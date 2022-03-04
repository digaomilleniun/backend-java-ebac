/**
 * 
 */
package br.com.rpires.VendaServiceProfessor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author rodrigo.pires
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.rpires.VendaServiceProfessor.repository")
public class MongoConfig {

}

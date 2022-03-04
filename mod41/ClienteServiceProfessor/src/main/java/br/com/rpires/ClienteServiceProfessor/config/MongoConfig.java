/**
 * 
 */
package br.com.rpires.ClienteServiceProfessor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author rodrigo.pires
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.rpires.ClienteServiceProfessor.repository")
public class MongoConfig {

}

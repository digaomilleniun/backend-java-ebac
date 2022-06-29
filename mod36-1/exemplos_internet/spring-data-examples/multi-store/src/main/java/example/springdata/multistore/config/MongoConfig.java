package example.springdata.multistore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * @author rodrigo.pires
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "example.springdata.multistore.shop")
public class MongoConfig {

	@Bean
    public MongoClient mongo() throws Exception {
        //final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/ebac");
		final ConnectionString connectionString = new ConnectionString("mongodb://admin:admin@127.0.0.1:27017/ebac?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false");
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "ebac");
    }

}

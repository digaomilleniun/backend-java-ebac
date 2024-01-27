package br.com.rpires.ClienteServiceProfessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import br.com.rpires.ebac.Springbootjsp.SpringbootJspApplication;

@SpringBootApplication
@RefreshScope
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ClienteServiceProfessorApplication {

	public static void main(String[] args) {
		SpringbootJspApplication.run(ClienteServiceProfessorApplication.class, args);
	}

}

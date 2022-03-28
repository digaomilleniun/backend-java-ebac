/**
 * 
 */
package br.com.rpires.VendaServiceProfessor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * @author rodrigo.pires
 *
 */
@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-version}") String appVersion) {
		return new OpenAPI()
				          .info(new Info()
				          .title("Serviço de vendas")
				          .version(appVersion)
				          .description("Serviço para gerenciamento de vendas")
				          .termsOfService("http://swagger.io/terms/")
				          .license(new License().name("Apache 2.0").url("http://springdoc.org"))
				          .contact(new Contact().name("Rodrigo Pires").email("rodrigo@rodrigo.com")));
	}
}

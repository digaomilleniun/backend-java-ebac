package com.example.ConfigServiceTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServiceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceTestApplication.class, args);
	}

}

package com.bank_management.lucas_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.bank_management.lucas_backend")
@EnableJpaRepositories(basePackages = "com.bank_management.lucas_backend.repository")
public class LucasBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucasBackendApplication.class, args);
	}

}

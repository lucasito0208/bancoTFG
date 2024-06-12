package com.lucasDev.imagin_banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class ImaginJavaVersionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImaginJavaVersionApplication.class, args);
    }


}

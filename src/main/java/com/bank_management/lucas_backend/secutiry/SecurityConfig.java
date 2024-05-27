package com.bank_management.lucas_backend.secutiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bank_management.lucas_backend.repository.UsuarioRepository;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final UsuarioRepository repositorio;

    public SecurityConfig(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

}

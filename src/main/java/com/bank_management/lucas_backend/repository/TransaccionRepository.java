package com.bank_management.lucas_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank_management.lucas_backend.entity.Transaccion;
import com.bank_management.lucas_backend.entity.Usuario;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

    Optional<Usuario> encontrarPorEmail(String email);

    
    
}

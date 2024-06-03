package com.bank_management.lucas_backend.repository;



import com.bank_management.lucas_backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);

    //Optional<Usuario> findByName(String nombre);
    Optional<Usuario> findByName(String nombre);
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAll();
    
}

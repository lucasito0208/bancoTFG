package com.bank_management.lucas_backend.repository;



import com.bank_management.lucas_backend.entity.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //List<Usuario> findAllUsuarios();

    Optional<Usuario> findUsuarioById(Long idUsuario);

}

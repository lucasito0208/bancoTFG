package com.lucasDev.imagin_banco.repository;

import com.lucasDev.imagin_banco.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNombreUsuario(String nombreUsuario);

    Optional<Usuario> findByOpNombreUsuario(String nombreUsuario);

    boolean existsByUsername(String nombreUsuario);
    boolean existsByEmail(String email);
    boolean existsByPassword(String password);

    Usuario findByEmail(String email);

    List<Usuario> findAll();
}

package com.lucasDev.imagin_banco.repository;

import com.lucasDev.imagin_banco.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNombreUsuario(String nombreUsuario);

    Usuario findByEmail(String email);

    List<Usuario> findAll();
}

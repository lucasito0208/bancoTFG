package com.bank_management.lucas_backend.service;

import java.util.List;
import java.util.Set;

import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;

public interface UsuarioServicio {

    List<UsuarioDto> dameListaUsuarios();

    UsuarioDto dameUsuarioPorId(Long id);

    UsuarioDto findByNombre(String nombre);

    UsuarioDto findByEmail(String email);

    boolean checkUserExists(String nombre, String email);

    boolean checkUsernameExists(String nombre);

    boolean checkEmailExists(String email);

    void save(Usuario usuario);

    Usuario createUser(Usuario user);

    void enableUser(String nombre);

    void disableUser(String nombre);
    
}

package com.lucasDev.imagin_banco.service;

import com.lucasDev.imagin_banco.model.dtos.UsuarioDto;
import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.security.RolesUsuarios;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UsuarioService {

    Usuario findByUsername(String nombreUsuario);

    Usuario findByEmail(String email);

    boolean checkUserExists(String nombreUsuario, String email);

    boolean checkUsernameExists(String nombreUsuario);

    boolean checkEmailExists(String email);

    void save(Usuario usuario);

    Usuario createUser(Usuario usuario, Set<RolesUsuarios> rolesUsuarios);

    Usuario saveUser(Usuario usuario);

    List<Usuario> findUserList();

    void enableUser(String nombreUsuario);

    void disableUser(String nombreUsuario);

}

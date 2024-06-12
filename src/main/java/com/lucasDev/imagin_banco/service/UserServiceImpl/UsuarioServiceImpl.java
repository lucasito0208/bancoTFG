package com.lucasDev.imagin_banco.service.UserServiceImpl;

import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.repository.RolRepository;
import com.lucasDev.imagin_banco.repository.UsuarioRepository;
import com.lucasDev.imagin_banco.security.RolesUsuarios;
import com.lucasDev.imagin_banco.service.CuentaService;
import com.lucasDev.imagin_banco.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final CuentaService cuentaService;

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario findByUsername(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }


    public Usuario createUser(Usuario usuario, Set<RolesUsuarios> rolesUsuarios) {
        Usuario localUsuario = usuarioRepository.findByNombreUsuario(usuario.getUsername());

        if (localUsuario != null) {
            log.info("El usuario {} ya existe. Elija otro nombre de usuario.", usuario.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(encryptedPassword);

            for (RolesUsuarios roles : rolesUsuarios) {
                rolRepository.save(roles.getRol());
            }

            usuario.getRolesUsuarios().addAll(rolesUsuarios);

            usuario.setTarjeta(cuentaService.createPrimaryAccount());
            usuario.setAhorros(cuentaService.createSavingsAccount());

            localUsuario = usuarioRepository.save(usuario);
        }

        return localUsuario;
    }

    public boolean checkUserExists(String username, String email) {
        return checkUsernameExists(username) || checkEmailExists(username);
    }

    public boolean checkUsernameExists(String username) {
        return null != findByUsername(username);

    }

    public boolean checkEmailExists(String email) {
        return null != findByEmail(email);

    }

    public Usuario saveUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findUserList() {
        return usuarioRepository.findAll();
    }

    public void enableUser(String username) {
        Usuario usuario = findByUsername(username);
        usuario.setDisponible(true);
        usuarioRepository.save(usuario);
    }

    public void disableUser(String username) {
        Usuario usuario = findByUsername(username);
        usuario.setDisponible(false);
        log.info("Estado del usuario : {}", usuario.isEnabled());
        usuarioRepository.save(usuario);
        log.info(username, "{}, no está disponible.");
    }
}

package com.lucasDev.imagin_banco.service.UserServiceImpl;

import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.repository.UsuarioRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioSecurityServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(@NotNull String nombreUsuario) throws UsernameNotFoundException {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByOpNombreUsuario(nombreUsuario);


        Usuario usuario = usuarioOptional.orElseThrow(() -> {
            log.warn("Usuario {} no encontrado", nombreUsuario);
            return new UsernameNotFoundException("Usuario " + nombreUsuario + " no encontrado");
        });


        return usuario;
    }
}


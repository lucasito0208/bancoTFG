package com.lucasDev.imagin_banco.service.UserServiceImpl;

import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserSecurityServiceImpl implements UserDetailsService {

    //private static final Logger LOG = LoggerFactory.getLogger(UserSecurityServiceImpl.class);

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(username);
        if (null == usuario) {
            //LOG.warn("Usuario {} no encontrado", username);
            log.warn("Usuario {} no encontrado", username);
            throw new UsernameNotFoundException("Usuario " + username + " no encontrado");
        }
        return usuario;
    }
}


package com.lucasDev.imagin_banco.service.UserServiceImpl;

import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.mapper.UsuarioMapper;
import com.lucasDev.imagin_banco.model.ModeloAuthRespuesta;
import com.lucasDev.imagin_banco.model.ModeloPeticionInicioSesion;
import com.lucasDev.imagin_banco.model.ModeloPeticionRegistro;
import com.lucasDev.imagin_banco.repository.UsuarioRepository;
import com.lucasDev.imagin_banco.security.jwt.JwtService;
import com.lucasDev.imagin_banco.service.AuthService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    public final UsuarioRepository usuarioRepository;
    public final UsuarioMapper usuarioMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public ModeloAuthRespuesta registro(ModeloPeticionRegistro request) {

        Usuario usuario = usuarioRepository.save(usuarioMapper.toEntityRegistro(request));

        return ModeloAuthRespuesta.builder()
                .token(jwtService.generarToken(usuario))
                .build();
    }

    @Override
    public ModeloAuthRespuesta inicio(ModeloPeticionInicioSesion request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getNombreUsuario(),
                        request.getPassword()
                )
        );

        Usuario usuarioDb = usuarioRepository.findByOpNombreUsuario(request.getNombreUsuario())
                .orElseThrow(() -> new EntityNotFoundException("El usuario " + request.getNombreUsuario() + " no existe"));

        return ModeloAuthRespuesta
                .builder()
                .token(jwtService.generarToken(usuarioDb))
                .build();
    }
    @Override
    public boolean datosEnUso(String email, String nombreUsuario, String password) {
        return usuarioRepository.existsByEmail(email)
                || usuarioRepository.existsByUsername(nombreUsuario)
                || usuarioRepository.existsByPassword(password);
    }
}

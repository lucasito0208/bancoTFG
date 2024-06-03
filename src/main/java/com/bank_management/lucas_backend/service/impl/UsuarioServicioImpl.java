package com.bank_management.lucas_backend.service.impl;

import java.util.List;
import java.util.Optional;

import com.bank_management.lucas_backend.mapper.AhorrosMapper;
import com.bank_management.lucas_backend.mapper.TarjetaMapper;
import com.bank_management.lucas_backend.repository.UsuarioRepository;
import com.bank_management.lucas_backend.service.CuentaServicio;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.mapper.UsuarioMapper;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;
import com.bank_management.lucas_backend.service.UsuarioServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioMapper mapperUsuario;

    private final TarjetaMapper mapperTarjeta;

    private final AhorrosMapper mapperAhorros;

    private final UsuarioRepository repositorio;

    private final PasswordEncoder condificadorPass;

    private final CuentaServicio cuentaServicio;


    @Override
    @Transactional
    public List<UsuarioDto> dameListaUsuarios() {

        return mapperUsuario.toListDto(repositorio.findAll());
        
    }

    @Override
    @Transactional
    public UsuarioDto dameUsuarioPorId(Long id) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("usuario con id:  " + id + " no encontrado"));

        return mapperUsuario.toDto(usuario);
        
    }

    @Override
    public UsuarioDto findByNombre(String nombre) {

        Usuario usuario = repositorio.findByName(nombre)
                .orElseThrow(() -> new EntityNotFoundException("Nombre " + nombre + " no encontrado"));

        return mapperUsuario.toDto(usuario);
    }

    @Override
    public UsuarioDto findByEmail(String email) {

        Usuario usuario = repositorio.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Email " + email + " no encontrado"));

        return mapperUsuario.toDto(usuario);
    }

    @Override
    public boolean checkUserExists(String nombre, String email) {
        return checkUsernameExists(nombre) || checkEmailExists(email);
    }

    @Override
    public boolean checkUsernameExists(String nombre) {
        return repositorio.findByName(nombre).isPresent();
    }

    @Override
    public boolean checkEmailExists(String email) {
        return repositorio.findByName(email).isPresent();
    }

    @Override
    public void save(Usuario usuario) {
        repositorio.save(usuario);
    }

    @Override
    public Usuario createUser(Usuario usuario) {
        Optional<Usuario> usuarioExistente = repositorio.findByName(usuario.getNombre());

        if(usuarioExistente.isPresent()) {
            log.info("El usuario " + usuario.getNombre() + " ya existe");
            throw new IllegalArgumentException("El usuario " + usuario.getNombre() + " ya existe");
        }

        String passwordSeguro = condificadorPass.encode(usuario.getPassword());
        usuario.setPassword(passwordSeguro);

        usuario.setCuentaTarjeta(mapperTarjeta.toTarjeta(cuentaServicio.crearTarjeta()));
        usuario.setCuentaAhorros(mapperAhorros.toAhorros(cuentaServicio.crearAhorros()));


        return repositorio.save(usuario);
    }

    public void enableUser(String username) {
        UsuarioDto usuarioDto = findByNombre(username);
        usuarioDto.setDisponible(true);
        repositorio.save(mapperUsuario.toUsuario(usuarioDto));
    }

    public void disableUser(String username) {
        UsuarioDto usuarioDto = findByNombre(username);
        usuarioDto.setDisponible(false);
        repositorio.save(mapperUsuario.toUsuario(usuarioDto));
    }

}

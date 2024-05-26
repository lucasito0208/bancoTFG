package com.bank_management.lucas_backend.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bank_management.lucas_backend.entity.Rol;
import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.mapper.UsuarioMapper;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioMapperImpl implements UsuarioMapper {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto toDto(Usuario usuario) {
        
        return UsuarioDto   
                .builder()
                .name(usuario.getNombre())
                .contacto(usuario.getContacto())
                .email(usuario.getEmail())
                .build();
    }

    @Override
    public Usuario toUsuario(UsuarioDto usuarioDto) {
        
        return Usuario
                .builder()
                .nombre(usuarioDto.getName())
                .rol(Rol.USUARIO)
                .email(usuarioDto.getEmail())
                .contacto(usuarioDto.getContacto())
                .password(passwordEncoder.encode(usuarioDto.getPassword()))
                .build();
    
    }

    @Override
    public List<UsuarioDto> toListDto(List<Usuario> listaUsuarios) {

        return listaUsuarios.stream().map(this::toDto).collect(Collectors.toList());
        
    }
    
}

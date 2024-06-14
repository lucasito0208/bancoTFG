package com.lucasDev.imagin_banco.mapper.impl;

import com.lucasDev.imagin_banco.model.ModeloPeticionRegistro;
import com.lucasDev.imagin_banco.model.dtos.UsuarioDto;
import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.mapper.AhorrosMapper;
import com.lucasDev.imagin_banco.mapper.TarjetaMapper;
import com.lucasDev.imagin_banco.mapper.UsuarioMapper;

public class UsuarioMapperImpl implements UsuarioMapper {

    public TarjetaMapper tarjetaMapper;
    public AhorrosMapper ahorrosMapper;


    @Override
    public UsuarioDto toDto(Usuario usuario) {
        return UsuarioDto.builder()
                .nombre(usuario.getNombre())
                .apellidos(usuario.getApellidos())
                .contacto(usuario.getContacto())
                .email(usuario.getEmail())
                .nombreUsuario(usuario.getUsername())
                .disponible(usuario.isEnabled())
                .tarjeta(tarjetaMapper.toDto(usuario.getTarjeta()))
                .ahorros(ahorrosMapper.toDto(usuario.getAhorros()))
                .build();
    }

    @Override
    public Usuario toEntity(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .nombre(usuarioDto.getNombre())
                .apellidos(usuarioDto.getApellidos())
                .contacto(usuarioDto.getContacto())
                .email(usuarioDto.getEmail())
                .nombreUsuario(usuarioDto.getNombreUsuario())
                .disponible(usuarioDto.isDisponible())
                .tarjeta(tarjetaMapper.toEntity(usuarioDto.getTarjeta()))
                .ahorros(ahorrosMapper.toEntity(usuarioDto.getAhorros()))
                .build();
    }

    @Override
    public Usuario toEntityRegistro(ModeloPeticionRegistro registro) {
        return Usuario.builder()
                .nombre(registro.getNombre())
                .apellidos(registro.getApellido())
                .email(registro.getEmail())
                .contacto(registro.getContacto())
                .nombreUsuario(registro.getNombreUsuario())
                .password(registro.getPassword())
                .build();
    }

    @Override
    public ModeloPeticionRegistro toModelo(Usuario usuario) {
        return ModeloPeticionRegistro.builder()
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellidos())
                .email(usuario.getEmail())
                .contacto(usuario.getContacto())
                .nombreUsuario(usuario.getNombre())
                .password(usuario.getPassword())
                .build();
    }
}

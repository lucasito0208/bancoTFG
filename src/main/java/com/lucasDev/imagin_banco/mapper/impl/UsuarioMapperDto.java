package com.lucasDev.imagin_banco.mapper.impl;

import com.lucasDev.imagin_banco.dto.UsuarioDto;
import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.mapper.UsuarioMapper;
import com.lucasDev.imagin_banco.repository.UsuarioRepository;

public class UsuarioMapperDto implements UsuarioMapper {


    @Override
    public UsuarioDto toDto(Usuario usuario) {
        return UsuarioDto.builder()
                .

                .build();
    }

    @Override
    public Usuario toEntity(UsuarioDto usuarioDto) {
        return null;
    }
}

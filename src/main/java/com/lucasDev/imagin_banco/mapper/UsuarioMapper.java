package com.lucasDev.imagin_banco.mapper;


import com.lucasDev.imagin_banco.dto.UsuarioDto;
import com.lucasDev.imagin_banco.entity.Usuario;

public interface UsuarioMapper {

    UsuarioDto toDto(Usuario usuario);

    Usuario toEntity(UsuarioDto usuarioDto);




}

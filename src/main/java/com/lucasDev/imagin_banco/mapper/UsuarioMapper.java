package com.lucasDev.imagin_banco.mapper;


import com.lucasDev.imagin_banco.model.ModeloPeticionRegistro;
import com.lucasDev.imagin_banco.model.dtos.UsuarioDto;
import com.lucasDev.imagin_banco.entity.Usuario;

public interface UsuarioMapper {

    UsuarioDto toDto(Usuario usuario);

    Usuario toEntity(UsuarioDto usuarioDto);

    Usuario toEntityRegistro(ModeloPeticionRegistro registro);

    ModeloPeticionRegistro toModelo(Usuario usuario);



}

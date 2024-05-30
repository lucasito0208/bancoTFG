package com.bank_management.lucas_backend.mapper;

import java.util.List;

import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;


public interface UsuarioMapper {

    UsuarioDto toDto(Usuario usuario);

    Usuario toUsuario(UsuarioDto usuarioDto);

    
}

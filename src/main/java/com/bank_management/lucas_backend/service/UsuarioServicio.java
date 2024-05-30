package com.bank_management.lucas_backend.service;

import java.util.List;

import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;

public interface UsuarioServicio {

    List<UsuarioDto> dameListaUsuarios();

    UsuarioDto dameUsuarioPorId(Long id);

    Usuario dameUsuarioN(Long id);

    
    
}

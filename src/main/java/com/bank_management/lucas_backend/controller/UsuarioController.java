package com.bank_management.lucas_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;

public interface UsuarioController {

    ResponseEntity<List<UsuarioDto>> dameListaDeUsuarios();

    ResponseEntity<Usuario> dameUsuarioNormal(Long id);
    
}

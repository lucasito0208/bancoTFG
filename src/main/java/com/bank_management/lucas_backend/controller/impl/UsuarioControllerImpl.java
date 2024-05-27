package com.bank_management.lucas_backend.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bank_management.lucas_backend.controller.UsuarioController;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;
import com.bank_management.lucas_backend.service.UsuarioServicio;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuario")
public class UsuarioControllerImpl implements UsuarioController{

    private final UsuarioServicio servicio;

    @Override
    @GetMapping("/listaUsuarios")
    public ResponseEntity<List<UsuarioDto>> dameListaDeUsuarios() {
        return ResponseEntity.ok().body(servicio.dameListaUsuarios());
    }
    
}

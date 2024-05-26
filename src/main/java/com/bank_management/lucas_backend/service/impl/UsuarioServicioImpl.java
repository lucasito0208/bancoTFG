package com.bank_management.lucas_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.mapper.UsuarioMapper;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;
import com.bank_management.lucas_backend.repository.UsuarioRepository;
import com.bank_management.lucas_backend.service.UsuarioServicio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepository repositorio;
    private final UsuarioMapper mapper;
  

    @Override
    public List<UsuarioDto> dameListaUsuarios() {

        return mapper.toListDto(repositorio.findAll());
        
    }

    @Override
    public UsuarioDto dameUsuarioPorId(Long id) {

        //Primero busco el usuario existente en la BD
        Usuario usuario = repositorio.encontrarUsuarioPorId(id);

        //Luego devuelto el usuario mapeado a dto
        return mapper.toDto(usuario);
        
    }
    
}

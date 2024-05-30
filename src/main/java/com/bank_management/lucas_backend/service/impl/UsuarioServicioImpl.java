package com.bank_management.lucas_backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.bank_management.lucas_backend.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.mapper.UsuarioMapper;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;
import com.bank_management.lucas_backend.service.UsuarioServicio;


import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioMapper mapper;

    private final UsuarioRepository repositorio;

    @Override
    @Transactional
    public List<UsuarioDto> dameListaUsuarios() {

        return repositorio
        .findAll()
        .stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());
        
    }

    @Override
    @Transactional
    public UsuarioDto dameUsuarioPorId(Long id) {

        //Primero busco el usuario existente en la BD
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("usuario con id:  " + id + " no encontrado"));

        //Luego devuelto el usuario mapeado a dto
        return mapper.toDto(usuario);
        
    }

    @Override
    @Transactional
    public Usuario dameUsuarioN(Long id) {
        return repositorio.findById(id).orElseThrow();
    }

    
    
}

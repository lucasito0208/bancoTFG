package com.bank_management.lucas_backend.service.impl;

import java.util.List;

import com.bank_management.lucas_backend.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.mapper.UsuarioMapper;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;
import com.bank_management.lucas_backend.service.UsuarioServicio;


import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private UsuarioRepository repositorio;

    @Override
    @Transactional
    public List<UsuarioDto> dameListaUsuarios() {

        return mapper.toListDto(repositorio.findAll());
        
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
    
}

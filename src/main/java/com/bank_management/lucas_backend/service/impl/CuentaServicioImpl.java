package com.bank_management.lucas_backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bank_management.lucas_backend.entity.Cuenta;
import com.bank_management.lucas_backend.mapper.CuentaMapper;
import com.bank_management.lucas_backend.modelo.dto.CuentaDto;
import com.bank_management.lucas_backend.repository.CuentaRepository;
import com.bank_management.lucas_backend.service.CuentaServicio;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaServicioImpl implements CuentaServicio {

    private final CuentaRepository repositorio;

    private final CuentaMapper mapper;

    @Override
    @Transactional
    public List<CuentaDto> listarCuentas() {

        return repositorio
        .findAll()
        .stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());

    }
    
}

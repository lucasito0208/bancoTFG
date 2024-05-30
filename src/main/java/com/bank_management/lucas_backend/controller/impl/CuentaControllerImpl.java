package com.bank_management.lucas_backend.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank_management.lucas_backend.controller.CuentaController;
import com.bank_management.lucas_backend.modelo.dto.CuentaDto;
import com.bank_management.lucas_backend.service.CuentaServicio;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cuenta")
@RequiredArgsConstructor
public class CuentaControllerImpl implements CuentaController {

    private final CuentaServicio servicio;
    
    
    @Override
    @GetMapping("/listar-cuentas")
    public ResponseEntity<List<CuentaDto>> listarCuentas() {
        return ResponseEntity.ok().body(servicio.listarCuentas());
    }
    
}

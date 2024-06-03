package com.bank_management.lucas_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank_management.lucas_backend.entity.CuentaTarjeta;

public interface CuentaTarjetaRepository extends JpaRepository<CuentaTarjeta, Long>  {

    
}

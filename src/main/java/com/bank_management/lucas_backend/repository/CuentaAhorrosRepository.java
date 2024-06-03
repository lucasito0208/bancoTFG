package com.bank_management.lucas_backend.repository;

import com.bank_management.lucas_backend.entity.CuentaAhorros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaAhorrosRepository extends JpaRepository<CuentaAhorros, Long> {
}

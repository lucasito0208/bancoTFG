package com.bank_management.lucas_backend.repository;

import com.bank_management.lucas_backend.entity.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compras, Long> {
}

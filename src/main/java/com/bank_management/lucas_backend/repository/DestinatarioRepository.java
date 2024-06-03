package com.bank_management.lucas_backend.repository;

import com.bank_management.lucas_backend.entity.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinatarioRepository extends JpaRepository<Destinatario, Long> {
}

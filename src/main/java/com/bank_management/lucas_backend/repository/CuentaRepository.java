package com.bank_management.lucas_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank_management.lucas_backend.entity.Cuenta;
import com.bank_management.lucas_backend.entity.Usuario;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>  {

    List<Cuenta> findAllByUsuario(Usuario usuario);

}

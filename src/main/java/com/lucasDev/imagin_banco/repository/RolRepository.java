package com.lucasDev.imagin_banco.repository;

import com.lucasDev.imagin_banco.security.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RolRepository extends JpaRepository<Rol, Integer> {

    Rol findByNombre(String nombre);
}

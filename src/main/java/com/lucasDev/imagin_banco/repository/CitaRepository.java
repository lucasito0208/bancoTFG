package com.lucasDev.imagin_banco.repository;

import com.lucasDev.imagin_banco.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findAll();
}

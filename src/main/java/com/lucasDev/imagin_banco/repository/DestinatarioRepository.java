package com.lucasDev.imagin_banco.repository;

import com.lucasDev.imagin_banco.entity.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DestinatarioRepository extends JpaRepository<Destinatario, Long> {

    List<Destinatario> findAll();

    Destinatario findByNombre(String nombreDestino);

    void deleteByNombre(String nombreDestino);
}

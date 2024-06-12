package com.lucasDev.imagin_banco.repository;

import com.lucasDev.imagin_banco.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    Tarjeta findByNumCuenta(int numCuenta);
}

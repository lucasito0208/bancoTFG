package com.lucasDev.imagin_banco.repository;

import com.lucasDev.imagin_banco.entity.Ahorros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AhorrosRepository extends JpaRepository<Ahorros, Long> {

    Ahorros findByNumCuenta(int numCuenta);
}

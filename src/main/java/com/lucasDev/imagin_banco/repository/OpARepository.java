package com.lucasDev.imagin_banco.repository;

import com.lucasDev.imagin_banco.entity.OpA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OpARepository extends JpaRepository<OpA, Long> {

    List<OpA> findAll();
}

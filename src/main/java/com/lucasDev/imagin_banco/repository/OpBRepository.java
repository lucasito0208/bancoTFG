package com.lucasDev.imagin_banco.repository;

import com.lucasDev.imagin_banco.entity.OpB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OpBRepository extends JpaRepository<OpB, Long> {

    List<OpB> findAll();
}

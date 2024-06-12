package com.lucasDev.imagin_banco.service;

import com.lucasDev.imagin_banco.entity.Cita;

import java.util.List;


public interface CitaService {

    Cita createAppointment(Cita cita);

    List<Cita> findAll();

    Cita findAppointment(Long id);

    void confirmAppointment(Long id);
}

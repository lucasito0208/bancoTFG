package com.lucasDev.imagin_banco.service;

import com.lucasDev.imagin_banco.entity.Cita;
import com.lucasDev.imagin_banco.model.dtos.CitaDto;

import java.util.List;


public interface CitaService {

    Cita createAppointment(Cita cita);

    CitaDto crearCita(Cita cita);

    List<Cita> findAll();

    List<CitaDto> listarCitas();

    Cita findAppointment(Long id);

    CitaDto dameCita(Long id);

    void confirmAppointment(Long id);

}

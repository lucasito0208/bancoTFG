package com.lucasDev.imagin_banco.mapper;

import com.lucasDev.imagin_banco.entity.Cita;
import com.lucasDev.imagin_banco.model.dtos.CitaDto;

public interface CitaMapper {

    CitaDto toCitaDto(Cita cita);

    Cita toCitaEntity(CitaDto citaDto);
}

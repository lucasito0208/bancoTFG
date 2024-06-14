package com.lucasDev.imagin_banco.mapper.impl;

import com.lucasDev.imagin_banco.entity.Cita;
import com.lucasDev.imagin_banco.mapper.CitaMapper;
import com.lucasDev.imagin_banco.mapper.UsuarioMapper;
import com.lucasDev.imagin_banco.model.dtos.CitaDto;

public class CitaMapperImpl implements CitaMapper {

    public UsuarioMapper usuarioMapper;

    @Override
    public CitaDto toCitaDto(Cita cita) {
        return CitaDto.builder()
                .fecha(cita.getFecha())
                .lugar(cita.getLugar())
                .motivo(cita.getMotivo())
                .confirmado(cita.isConfirmado())
                .usuario(usuarioMapper.toDto(cita.getUsuario()))
                .build();
    }

    @Override
    public Cita toCitaEntity(CitaDto citaDto) {
        return Cita.builder()
                .fecha(citaDto.getFecha())
                .lugar(citaDto.getLugar())
                .motivo(citaDto.getMotivo())
                .confirmado(citaDto.isConfirmado())
                .usuario(usuarioMapper.toEntity(citaDto.getUsuario()))
                .build();
    }
}

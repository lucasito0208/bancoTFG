package com.lucasDev.imagin_banco.service.UserServiceImpl;

import com.lucasDev.imagin_banco.entity.Cita;
import com.lucasDev.imagin_banco.mapper.CitaMapper;
import com.lucasDev.imagin_banco.model.dtos.CitaDto;
import com.lucasDev.imagin_banco.repository.CitaRepository;
import com.lucasDev.imagin_banco.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    private final CitaMapper citaMapper;

    public Cita createAppointment(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public CitaDto crearCita(Cita cita) {
        return citaMapper.toCitaDto(citaRepository.save(cita));
    }

    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public List<CitaDto> listarCitas() {
        return citaRepository.findAll().stream().map(citaMapper :: toCitaDto).toList();
    }

    public Cita findAppointment(Long id) {
        return citaRepository.findById(id).get();
    }

    @Override
    public CitaDto dameCita(Long id) {
        return citaMapper.toCitaDto(citaRepository.findById(id).get());
    }

    public void confirmAppointment(Long id) {
        Cita cita = findAppointment(id);
        cita.setConfirmado(true);
        citaRepository.save(cita);
    }

    public void confirmarCita(Long id) {
        CitaDto cita = dameCita(id);
        cita.setConfirmado(true);
        citaRepository.save(citaMapper.toCitaEntity(cita));
    }
}

package com.lucasDev.imagin_banco.service.UserServiceImpl;

import com.lucasDev.imagin_banco.entity.Cita;
import com.lucasDev.imagin_banco.repository.CitaRepository;
import com.lucasDev.imagin_banco.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    public Cita createAppointment(Cita cita) {
        return citaRepository.save(cita);
    }

    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    public Cita findAppointment(Long id) {
        return citaRepository.findById(id).get();
    }

    public void confirmAppointment(Long id) {
        Cita cita = findAppointment(id);
        cita.setConfirmado(true);
        citaRepository.save(cita);
    }
}

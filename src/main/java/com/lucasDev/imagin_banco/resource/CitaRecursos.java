package com.lucasDev.imagin_banco.resource;

import com.lucasDev.imagin_banco.entity.Cita;
import com.lucasDev.imagin_banco.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cita")
@PreAuthorize("hasRole('ADMIN')")
public class CitaRecursos {

    private final CitaService citaService;

    @Autowired
    public CitaRecursos(CitaService citaService) {
        this.citaService = citaService;
    }

    @RequestMapping("/all")
    public List<Cita> dameListaCitas() {
        return citaService.findAll();
    }

    @RequestMapping("/{id}/confirm")
    public void confirmaCita(@PathVariable("id") Long id) {
        citaService.confirmAppointment(id);
    }
}

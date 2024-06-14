package com.lucasDev.imagin_banco.controller;

import com.lucasDev.imagin_banco.model.dtos.CitaDto;
import org.springframework.ui.Model;

import java.security.Principal;
import java.text.ParseException;

public interface CitaController {

    String crearCita(Model model);

    String crearCitaPost(CitaDto cita, String fecha, Principal principal) throws ParseException;
}

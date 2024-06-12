package com.lucasDev.imagin_banco.controller.impl;

import com.lucasDev.imagin_banco.entity.Cita;
import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.service.CitaService;
import com.lucasDev.imagin_banco.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Controller
@RequestMapping("/cita")
@RequiredArgsConstructor
public class CitaControllerImpl {

    private final CitaService citaService;

    private final UsuarioService usuarioService;

    @GetMapping(value = "/crear")
    public String createAppointment(Model model) {
        Cita cita = new Cita();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String fechaActual = now.format(formatter);

        model.addAttribute("fechaActual", fechaActual);
        model.addAttribute("cita", cita);
        model.addAttribute("fecha", "");

        return "cita";
    }

    @PostMapping(value = "/crear")
    public String createAppointmentPost(@ModelAttribute("cita") Cita cita, @ModelAttribute("fecha") String fecha, Model model, Principal principal) throws ParseException {

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d1 = format1.parse(fecha);
        cita.setFecha(d1);

        Usuario usuario = usuarioService.findByUsername(principal.getName());
        cita.setUsuario(usuario);

        citaService.createAppointment(cita);

        return "redirect:/userFront";
    }


}

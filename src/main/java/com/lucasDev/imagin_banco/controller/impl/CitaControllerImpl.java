package com.lucasDev.imagin_banco.controller.impl;

import com.lucasDev.imagin_banco.controller.CitaController;
import com.lucasDev.imagin_banco.entity.Cita;
import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.mapper.CitaMapper;
import com.lucasDev.imagin_banco.mapper.UsuarioMapper;
import com.lucasDev.imagin_banco.model.dtos.CitaDto;
import com.lucasDev.imagin_banco.model.dtos.UsuarioDto;
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
public class CitaControllerImpl implements CitaController {

    private final CitaService citaService;
    private final CitaMapper citaMapper;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioService usuarioService;


    @GetMapping(value = "/crear")
    public String crearCita(Model model) {
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
    public String crearCitaPost(@ModelAttribute("cita") CitaDto cita, @ModelAttribute("fecha") String fecha, Principal principal) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date fechaActual = formato.parse(fecha);
        cita.setFecha(fechaActual);

        UsuarioDto usuario = usuarioMapper.toDto(usuarioService.findByUsername(principal.getName()));
        cita.setUsuario(usuario);

        citaService.crearCita(citaMapper.toCitaEntity(cita));

        return "redirect:/userFront";
    }


}

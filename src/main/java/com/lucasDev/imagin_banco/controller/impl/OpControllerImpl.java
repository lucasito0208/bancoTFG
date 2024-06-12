package com.lucasDev.imagin_banco.controller.impl;

import com.lucasDev.imagin_banco.entity.Destinatario;
import com.lucasDev.imagin_banco.entity.Tarjeta;
import com.lucasDev.imagin_banco.entity.Ahorros;
import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.service.OpService;
import com.lucasDev.imagin_banco.service.UsuarioService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Builder
@Controller
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class OpControllerImpl {

    private final OpService opService;

    private final UsuarioService usuarioService;

    @GetMapping(value = "/cuentas")
    public String entreCuentas(Model model) {

        model.addAttribute("desde", "");
        model.addAttribute("hasta", "");
        model.addAttribute("cantidad", "");

        return "cuentas";
    }

    @PostMapping(value = "/cuentas")
    public String entreCuentasEdit(
            @ModelAttribute("desde") String desde,
            @ModelAttribute("hasta") String hasta,
            @ModelAttribute("cantidad") String cantidad,
            Principal principal
    ) throws Exception {
        try {

            Usuario usuario = usuarioService.findByUsername(principal.getName());
            Tarjeta tarjeta = usuario.getTarjeta();
            Ahorros ahorros = usuario.getAhorros();
            double cantidadDouble;

            try {
                cantidadDouble = Double.parseDouble(cantidad);
                if (cantidadDouble <= 0) {
                    throw new IllegalArgumentException("La cantidad debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("La cantidad debe ser un número válido.");
        }

            // Verificación de cuentas válidas
            if (!desde.equals("tarjeta") && !desde.equals("ahorros")) {
                throw new IllegalArgumentException("La cuenta de origen no es válida.");
            }
            if (!hasta.equals("tarjeta") && !hasta.equals("ahorros")) {
                throw new IllegalArgumentException("La cuenta de destino no es válida.");
            }
            if (desde.equals(hasta)) {
                throw new IllegalArgumentException("La cuenta de origen y destino no pueden ser la misma.");
            }

                opService.transferirEntreCuentas(desde, hasta, String.valueOf(cantidadDouble), tarjeta, ahorros);

                return "redirect:/userFront";

        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            return "redirect:/error";
        }
    }

    @GetMapping(value = "/destino")
    public String recipient(Model model, Principal principal) {
        List<Destinatario> destinatarioList = opService.listaDestinatarios(principal);

        Destinatario destinatario = new Destinatario();

        model.addAttribute("listaDestino", destinatarioList);
        model.addAttribute("destino", destinatario);

        return "destino";
    }

    @PostMapping(value = "/destino/guardar")
    public String recipientPost(@ModelAttribute("destinatario") Destinatario destinatario, Principal principal) {

        Usuario usuario = usuarioService.findByUsername(principal.getName());
        destinatario.setUsuario(usuario);
        opService.guardarDestinatario(destinatario);

        return "redirect:/transfer/destino";
    }

    @GetMapping(value = "/destino/editar")
    public String recipientEdit(@RequestParam(value = "nombreDestino") String nombreDestino, Model model, Principal principal) {

        Destinatario destinatario = opService.dameDestinatarioPorNombre(nombreDestino);
        List<Destinatario> destinatarioList = opService.listaDestinatarios(principal);

        model.addAttribute("listaDestino", destinatarioList);
        model.addAttribute("destino", destinatario);

        return "destino";
    }

    @GetMapping(value = "/destino/borrar")
    @Transactional
    public String recipientDelete(@RequestParam(value = "nombreDestino") String nombreDestino, Model model, Principal principal) {

        opService.borrarDestinatario(nombreDestino);

        List<Destinatario> destinatarioList = opService.listaDestinatarios(principal);

        Destinatario destinatario = new Destinatario();
        model.addAttribute("destino", destinatario);
        model.addAttribute("listaDestino", destinatarioList);


        return "destino";
    }

    @GetMapping(value = "/otraCuenta")
    public String toSomeoneElse(Model model, Principal principal) {
        List<Destinatario> destinatarioList = opService.listaDestinatarios(principal);

        model.addAttribute("listaDestino", destinatarioList);
        model.addAttribute("tipo", "");

        return "otraCuenta";
    }

    @PostMapping(value = "/otraCuenta")
    public String toSomeoneElsePost(@ModelAttribute("nombreDestino") String nombreDestino, @ModelAttribute("tipo") String tipo, @ModelAttribute("cantidad") String cantidad, Principal principal) {
        Usuario usuario = usuarioService.findByUsername(principal.getName());
        Destinatario destinatario = opService.dameDestinatarioPorNombre(nombreDestino);
        opService.transferirDestinatario(destinatario, tipo, cantidad, usuario.getTarjeta(), usuario.getAhorros());

        return "redirect:/userFront";
    }
}

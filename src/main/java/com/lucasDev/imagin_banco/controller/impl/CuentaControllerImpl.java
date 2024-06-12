package com.lucasDev.imagin_banco.controller.impl;

import com.lucasDev.imagin_banco.entity.*;
import com.lucasDev.imagin_banco.service.CuentaService;
import com.lucasDev.imagin_banco.service.OpService;
import com.lucasDev.imagin_banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cuenta")
public class CuentaControllerImpl {

    private final UsuarioService usuarioService;

    private final CuentaService cuentaService;

    private final OpService opService;

    @Autowired
    public CuentaControllerImpl(UsuarioService usuarioService, CuentaService cuentaService, OpService opService) {
        this.usuarioService = usuarioService;
        this.cuentaService = cuentaService;
        this.opService = opService;
    }

    @RequestMapping("/tarjeta")
    public String cuentaTarjeta(Model model, Principal principal) {
        List<OpA> opAList = opService.listarOperacionesTarjeta(principal.getName());

        Usuario usuario = usuarioService.findByUsername(principal.getName());
        Tarjeta tarjeta = usuario.getTarjeta();

        model.addAttribute("tarjeta", tarjeta);
        model.addAttribute("lista_op_a", opAList);

        return "tarjeta";
    }

    @RequestMapping("/ahorros")
    public String savingsAccount(Model model, Principal principal) {
        List<OpB> opBList = opService.listarOperacionesAhorros(principal.getName());
        Usuario usuario = usuarioService.findByUsername(principal.getName());
        Ahorros ahorros = usuario.getAhorros();

        model.addAttribute("ahorros", ahorros);
        model.addAttribute("lista_op_b", opBList);

        return "ahorros";
    }

    @RequestMapping(value = "/deposito", method = RequestMethod.GET)
    public String deposito(Model model) {
        model.addAttribute("tipo", "");
        model.addAttribute("cantidad", "");

        return "deposito";
    }

    @RequestMapping(value = "/deposito", method = RequestMethod.POST)
    public String depositPOST(@ModelAttribute("cantidad") String amount, @ModelAttribute("tipo") String accountType, Principal principal) {
        cuentaService.deposito(accountType, Double.parseDouble(amount), principal);

        return "redirect:/userFront";
    }

    @RequestMapping(value = "/retiro", method = RequestMethod.GET)
    public String withdraw(Model model) {
        model.addAttribute("tipo", "");
        model.addAttribute("cantidad", "");

        return "retiro";
    }

    @RequestMapping(value = "/retiro", method = RequestMethod.POST)
    public String withdrawPOST(@ModelAttribute("cantidad") String amount, @ModelAttribute("tipo") String accountType, Principal principal) {
        cuentaService.retiro(accountType, Double.parseDouble(amount), principal);

        return "redirect:/userFront";
    }
}

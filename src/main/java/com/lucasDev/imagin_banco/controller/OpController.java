package com.lucasDev.imagin_banco.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

public interface OpController {

    String entreCuentas(Model model);

    String editarEntreCuentas(String desde, String hasta, String cantidad, Principal principal);

}

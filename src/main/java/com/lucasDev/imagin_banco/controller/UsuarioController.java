package com.lucasDev.imagin_banco.controller;

import com.lucasDev.imagin_banco.entity.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;

@Service
public interface UsuarioController {

    String perfil(Principal principal, Model model);

    String editarPerfil(Usuario usuario, Model model);
}

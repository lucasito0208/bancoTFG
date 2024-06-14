package com.lucasDev.imagin_banco.controller.impl;

import com.lucasDev.imagin_banco.controller.UsuarioController;
import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.service.UsuarioService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Builder
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/profile")
    public String perfil(Principal principal, Model model) {

        Usuario usuario = usuarioService.findByUsername(principal.getName());

        model.addAttribute("usuario", usuario);

        return "profile";
    }


    @PostMapping("/profile")
    public String editarPerfil(@ModelAttribute("usuario") Usuario usuario, Model model) {

        Usuario usuarioDb = usuarioService.findByUsername(usuario.getUsername());

        usuarioDb.setNombreUsuario(usuario.getUsername());
        usuarioDb.setNombre(usuario.getNombre());
        usuarioDb.setApellidos(usuario.getApellidos());
        usuarioDb.setEmail(usuario.getEmail());
        usuarioDb.setContacto(usuario.getContacto());

        // Guardar el usuario actualizado
        model.addAttribute("usuario", usuarioDb);

        usuarioService.saveUser(usuarioDb);

        return "profile";
    }


}

package com.lucasDev.imagin_banco.controller.impl;

import com.lucasDev.imagin_banco.entity.Tarjeta;
import com.lucasDev.imagin_banco.entity.Ahorros;
import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.mapper.UsuarioMapper;
import com.lucasDev.imagin_banco.repository.RolRepository;
import com.lucasDev.imagin_banco.security.RolesUsuarios;
import com.lucasDev.imagin_banco.service.AuthService;
import com.lucasDev.imagin_banco.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequiredArgsConstructor
public class InicioControllerImpl {

    private final UsuarioService usuarioService;

    private final UsuarioMapper usuarioMapper;

    private final AuthService authService;

    private final RolRepository rolRepository;



    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/signup")
    public String registro(Model model) {
        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);

        return "signup";
    }

    @PostMapping("/signup")
    public String registroPost(@ModelAttribute("usuario") Usuario usuario, Model model) {

        if (authService.datosEnUso(usuario.getEmail(), usuario.getUsername(), usuario.getPassword())) {

            model.addAttribute("emailExists", true);
            model.addAttribute("usernameExists", true);

            return "signup";
        } else {
            Set<RolesUsuarios> rolesUsuarios = new HashSet<>();
            rolesUsuarios.add(new RolesUsuarios(usuario, rolRepository.findByNombre("USUARIO")));

            authService.registro(usuarioMapper.toModelo(usuario));

            return "redirect:/";
        }
    }

    @GetMapping("/userFront")
    public String userFront(Principal principal, Model model) {
        Usuario usuario = usuarioService.findByUsername(principal.getName());
        Tarjeta tarjeta = usuario.getTarjeta();
        Ahorros ahorros = usuario.getAhorros();

        model.addAttribute("tarjeta", tarjeta);
        model.addAttribute("ahorros", ahorros);

        return "userFront";
    }
}

package com.lucasDev.imagin_banco.resource;

import com.lucasDev.imagin_banco.entity.OpA;
import com.lucasDev.imagin_banco.entity.OpB;
import com.lucasDev.imagin_banco.entity.Usuario;
import com.lucasDev.imagin_banco.service.OpService;
import com.lucasDev.imagin_banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')")
public class UsuarioRecursos {

    private final UsuarioService usuarioService;

    private final OpService opService;

    @Autowired
    public UsuarioRecursos(UsuarioService usuarioService, OpService opService) {
        this.usuarioService = usuarioService;
        this.opService = opService;
    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public List<Usuario> listaUsuarios() {
        return usuarioService. findUserList();
    }

    @RequestMapping(value = "/user/primary/transaction", method = RequestMethod.GET)
    public List<OpA> getListaOperacionesTarjeta(@RequestParam("nombreUsuario") String username) {
        return opService.listarOperacionesTarjeta(username);
    }

    @RequestMapping(value = "/user/savings/transaction", method = RequestMethod.GET)
    public List<OpB> getListaOperacionesAhorros(@RequestParam("nombreUsuario") String username) {
        return opService.listarOperacionesAhorros(username);
    }

    @RequestMapping("/user/{nombreUsuario}/enable")
    public void enableUser(@PathVariable("nombreUsuario") String nombreUsuario) {
        usuarioService.enableUser(nombreUsuario);
    }

    @RequestMapping("/user/{nombreUsuario}/disable")
    public void disableUser(@PathVariable("nombreUsuario") String nombreUsuario) {
        usuarioService.disableUser(nombreUsuario);
    }
}

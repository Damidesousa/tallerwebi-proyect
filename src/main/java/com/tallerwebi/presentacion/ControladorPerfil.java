package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.PerfilUsuario;
import com.tallerwebi.dominio.ServicioPerfil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/perfil")
public class ControladorPerfil {

    private final ServicioPerfil servicioPerfil;

    public ControladorPerfil(ServicioPerfil servicioPerfil) {
        this.servicioPerfil = servicioPerfil;
    }

    @GetMapping("/{usuarioId}")
    public String verPerfil(@PathVariable Long usuarioId, Model model) {
        PerfilUsuario perfil = servicioPerfil.obtenerPerfil(usuarioId);
        model.addAttribute("perfil", perfil);
        return "perfil";
    }

    @PostMapping("/guardar")
    public String guardarPerfil(@ModelAttribute PerfilUsuario perfil) {
        servicioPerfil.actualizarPerfil(perfil);
        return "redirect:/perfil/" + perfil.getUsuarioId();
    }
}

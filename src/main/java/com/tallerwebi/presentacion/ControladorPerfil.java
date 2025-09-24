package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.PerfilUsuario;
import com.tallerwebi.dominio.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ControladorPerfil {

    // Reemplazar BDD
    private PerfilUsuario perfil = new PerfilUsuario("Agustin", "uploads/default.png", "Hola!");

    @GetMapping("/perfil")
    public String mostrarPerfil(ModelMap model) {
        model.addAttribute("perfil", perfil);
        return "thymeleaf/perfil";
    }

    @PostMapping("/perfil/guardar")
    public String guardarPerfil(@RequestParam("nombre") String nombre,
                                @RequestParam("biografia") String biografia,
                                @RequestParam(value = "avatar", required = false) MultipartFile avatar,
                                ModelMap model) throws IOException {

        perfil.setNombre(nombre);
        perfil.setBiografia(biografia);

        if (avatar != null && !avatar.isEmpty()) {
            String uploadDir = "src/main/webapp/resources/uploads/";
            File directorio = new File(uploadDir);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            String filePath = uploadDir + avatar.getOriginalFilename();
            avatar.transferTo(new File(filePath));

            perfil.setAvatar("/resources/uploads/" + avatar.getOriginalFilename());
        }

        model.addAttribute("perfil", perfil);
        return "thymeleaf/perfil"; 
    }
}

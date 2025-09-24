package com.tallerwebi.integracion;

import com.tallerwebi.dominio.PerfilUsuario;
import com.tallerwebi.dominio.Usuario;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PerfilUsuarioTest {

    @Test
    public void deberiaActualizarElNombreDelPerfil() {
        PerfilUsuario perfil = new PerfilUsuario("Agustin", "uploads/agus.png", "Hola, soy Agustin");
        perfil.setNombre("AgusY");
        assertThat(perfil.getNombre()).isEqualTo("AgusY");
    }

    @Test
    public void deberiaActualizarLaBiografiaDelPerfil() {
        PerfilUsuario perfil = new PerfilUsuario("Agustin", "uploads/agus.png", "Hola, soy Agustin");
        perfil.setBiografia("Nueva biografía");
        assertThat(perfil.getBiografia()).isEqualTo("Nueva biografía");
    }

    @Test
    public void deberiaActualizarElAvatarDelPerfil() {
        PerfilUsuario perfil = new PerfilUsuario("Agustin", "uploads/agus.png", "Hola, soy Agustin");
        perfil.setAvatar("uploads/nuevoAvatar.png");
        assertThat(perfil.getAvatar()).isEqualTo("uploads/nuevoAvatar.png");
    }

    @Test
    public void deberiaAsociarUnPerfilAUnUsuario() {
        Usuario usuario = new Usuario();
        PerfilUsuario perfil = new PerfilUsuario("Agustin", "uploads/agus.png", "Hola!", usuario);

        assertThat(perfil.getUsuario()).isEqualTo(usuario);
    }

    @Test
    public void deberiaPermitirActualizarLosTresCamposDelPerfil() {
        PerfilUsuario perfil = new PerfilUsuario("Agustin", "uploads/agus.png", "Hola!");

        perfil.setNombre("AgusY");
        perfil.setAvatar("uploads/avatarNuevo.png");
        perfil.setBiografia("Nueva bio");

        assertThat(perfil.getNombre()).isEqualTo("AgusY");
        assertThat(perfil.getAvatar()).isEqualTo("uploads/avatarNuevo.png");
        assertThat(perfil.getBiografia()).isEqualTo("Nueva bio");
    }
}

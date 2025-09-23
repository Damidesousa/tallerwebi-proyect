package com.tallerwebi.integracion;

import com.tallerwebi.dominio.PerfilUsuario;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PerfilUsuarioTest {

    @Test
    public void deberiaActualizarElNombreDelPerfil() {
        
        PerfilUsuario perfil = new PerfilUsuario("Agustin", "uploads/agus.png", "Hola, soy Agustin");

        
        perfil.setNombre("AgusY");

        
        assertThat(perfil.getNombre()).isEqualTo("AgusY");
    }
}

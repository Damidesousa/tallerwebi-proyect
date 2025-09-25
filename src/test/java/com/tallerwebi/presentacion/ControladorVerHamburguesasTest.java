package com.tallerwebi.presentacion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import com.tallerwebi.dominio.ServicioVerHamburguesa;

public class ControladorVerHamburguesasTest {
    @Test
    public void dadoQuePidoVerHamburguesaQueMeLleveASuVistaCorrectamente() {
        ServicioVerHamburguesa sevicioVerHamburguesa = mock(ServicioVerHamburguesa.class);
        ControladorVerHamburguesa controladorVerHamburguesa = new ControladorVerHamburguesa(sevicioVerHamburguesa);
        ModelAndView modelAndView = controladorVerHamburguesa.irAMostrarHamburguesa();
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("hamburguesa"));
    }
}

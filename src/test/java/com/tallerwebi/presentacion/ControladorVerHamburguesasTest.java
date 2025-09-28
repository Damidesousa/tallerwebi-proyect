package com.tallerwebi.presentacion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import com.tallerwebi.dominio.Hamburguesa;
import com.tallerwebi.dominio.ServicioVerHamburguesa;

public class ControladorVerHamburguesasTest {
   

   @Test
   public void DadoQuePidoVerHamburguesaConIdQueNoExisteDeberiaMostrarError(){
    
       ServicioVerHamburguesa servicioVerHamburguesaMock=mock(ServicioVerHamburguesa.class);
       ControladorVerHamburguesa controladorVerHamburguesa=new ControladorVerHamburguesa(servicioVerHamburguesaMock);

       // ejecucion
       ModelAndView modelAndView = controladorVerHamburguesa.mostrarHamburguesaPorId(2L);

       // validacion
       assertThat(modelAndView.getViewName(), equalToIgnoringCase("hamburguesa"));
       assertThat(modelAndView.getModel().get("error").toString(), equalToIgnoringCase("Hamburguesa no encontrada"));
   }

    @Test
    public void DadoQuePidoVerHamburguesaConIdDeberiaMostrarHamburguesa(){
    
        ServicioVerHamburguesa servicioVerHamburguesaMock=mock(ServicioVerHamburguesa.class);
        Hamburguesa hamburguesaMock=mock(Hamburguesa.class);
        when(hamburguesaMock.getId()).thenReturn(1L);
        when(hamburguesaMock.getNombre()).thenReturn("Cheeseburger");
        when(hamburguesaMock.getDescripcion()).thenReturn("Hamburguesa con queso cheddar");
        when(hamburguesaMock.getPrecio()).thenReturn(500.0);
        when(servicioVerHamburguesaMock.buscarPorId(1L)).thenReturn(hamburguesaMock);
        ControladorVerHamburguesa controladorVerHamburguesa=new ControladorVerHamburguesa(servicioVerHamburguesaMock);

        // ejecucion
        ModelAndView modelAndView = controladorVerHamburguesa.mostrarHamburguesaPorId(1L);

        // validacion
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("hamburguesa"));
        assertThat(((Hamburguesa)modelAndView.getModel().get("hamburguesa")).getId(), equalTo(1L));
        assertThat(((Hamburguesa)modelAndView.getModel().get("hamburguesa")).getNombre(), equalToIgnoringCase("Cheeseburger"));
        assertThat(((Hamburguesa)modelAndView.getModel().get("hamburguesa")).getDescripcion(), equalToIgnoringCase("Hamburguesa con queso cheddar"));
        assertThat(((Hamburguesa)modelAndView.getModel().get("hamburguesa")).getPrecio(), equalTo(500.0));
    }

}

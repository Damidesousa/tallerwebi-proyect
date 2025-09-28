package com.tallerwebi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tallerwebi.dominio.Hamburguesa;
import com.tallerwebi.dominio.ServicioVerHamburguesa;

@Controller
public class ControladorVerHamburguesa {
    private ServicioVerHamburguesa servicioVerHamburguesa;

    @Autowired
    public ControladorVerHamburguesa(ServicioVerHamburguesa sevicioVerHamburguesa) {
        this.servicioVerHamburguesa=sevicioVerHamburguesa;
    }

    @RequestMapping(path = "/hamburguesa", method = RequestMethod.GET, params = "!id")
    public ModelAndView irAMostrarHamburguesa() {
        ModelMap modelo = new ModelMap();
        modelo.put("error", "No se especificó ninguna hamburguesa");
        return new ModelAndView("hamburguesa", modelo);
    }

    @RequestMapping(path = "/hamburguesa", method = RequestMethod.GET)
    public ModelAndView mostrarHamburguesaPorId(Long id) {
        ModelMap modelo = new ModelMap();
        Hamburguesa hamburguesa = servicioVerHamburguesa.buscarPorId(id);
        if (hamburguesa != null) {
            modelo.put("hamburguesa", hamburguesa);
            return new ModelAndView("hamburguesa", modelo);
        } else {
            modelo.put("error", "Hamburguesa no encontrada");
            return new ModelAndView("hamburguesa", modelo);
        }
    }
}

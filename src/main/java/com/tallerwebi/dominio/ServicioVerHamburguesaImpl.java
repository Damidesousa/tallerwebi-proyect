package com.tallerwebi.dominio;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tallerwebi.dominio.Hamburguesa;

@Service("servicioVerHamburguesa")
@Transactional
public class ServicioVerHamburguesaImpl implements ServicioVerHamburguesa {

    private RepositorioVerHamburguesa repositorioVerHamburguesa;

    @Autowired
    public ServicioVerHamburguesaImpl(RepositorioVerHamburguesa repositorioVerHamburguesa) {
        this.repositorioVerHamburguesa = repositorioVerHamburguesa;
    }

    @Override
    public Hamburguesa buscarPorId(Long id) {
        return repositorioVerHamburguesa.buscarPorId(id);
    }
}
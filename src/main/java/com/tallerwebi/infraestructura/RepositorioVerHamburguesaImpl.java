package com.tallerwebi.infraestructura;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.tallerwebi.dominio.Hamburguesa;
import com.tallerwebi.dominio.RepositorioVerHamburguesa;

@Repository
public class RepositorioVerHamburguesaImpl implements RepositorioVerHamburguesa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Hamburguesa buscarPorId(Long id) {
        return em.find(Hamburguesa.class, id);
    }
}
package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

import com.tallerwebi.dominio.excepcion.UsuarioExistente;
import com.tallerwebi.dominio.excepcion.UsuarioNoValido;

@Service
public interface ServicioLogin {

    Usuario consultarUsuario(String email, String password);
    void registrar(Usuario usuario) throws UsuarioExistente;
    Boolean validarNuevoUsuario(Usuario usuario)throws UsuarioNoValido;
}

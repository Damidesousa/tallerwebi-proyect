package com.tallerwebi.dominio.excepcion;

public class UsuarioNoValido extends Exception {
    public UsuarioNoValido(String mensaje) {
        super(mensaje);
    }
}

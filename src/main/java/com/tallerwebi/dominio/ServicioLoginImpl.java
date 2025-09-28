package com.tallerwebi.dominio;

import com.tallerwebi.dominio.RepositorioUsuario;
import com.tallerwebi.dominio.ServicioLogin;
import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.dominio.excepcion.UsuarioExistente;
import com.tallerwebi.dominio.excepcion.UsuarioNoValido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioLoginImpl(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Usuario consultarUsuario (String email, String password) {
        return repositorioUsuario.buscarUsuario(email, password);
    }

    @Override
    public void registrar(Usuario usuario) throws UsuarioExistente {
        Usuario usuarioEncontrado = repositorioUsuario.buscarUsuario(usuario.getEmail(), usuario.getPassword());
        if(usuarioEncontrado != null){
            throw new UsuarioExistente();
        }
        repositorioUsuario.guardar(usuario);
    }

    @Override
    public Boolean validarNuevoUsuario(Usuario usuario)throws UsuarioNoValido {
        if(usuario.getEmail() == null || !usuario.getEmail().contains("@") || usuario.getEmail().length() > 100){
            throw new UsuarioNoValido("El email es obligatorio, debe ser valido y no debe superar los 100 caracteres");
        }
        if(usuario.getPassword() == null || usuario.getPassword().length() < 8){
            throw new UsuarioNoValido("La contraseña es obligatoria y debe tener al menos 8 caracteres");
        }
        if(usuario.getEdad() < 18){
            throw new UsuarioNoValido("El usuario debe ser mayor de 18 años");
        }
        if(usuario.getNombre() == null || usuario.getNombre().length() >= 50){
            throw new UsuarioNoValido("El nombre es obligatorio y no debe superar los 50 caracteres");
        }
        if(usuario.getDescripcion() != null && usuario.getDescripcion().length() > 200){
            throw new UsuarioNoValido("La descripcion no debe superar los 200 caracteres");
        }
        return true;
    }

    
}


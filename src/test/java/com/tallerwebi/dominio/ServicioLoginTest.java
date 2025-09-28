package com.tallerwebi.dominio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.tallerwebi.dominio.excepcion.UsuarioNoValido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


public class ServicioLoginTest {
    private ServicioLoginImpl servicioLogin;
    private RepositorioUsuario repositorioUsuarioMock;
    
    @BeforeEach
    public void init(){
        repositorioUsuarioMock = mock(RepositorioUsuario.class);
        servicioLogin = new ServicioLoginImpl(repositorioUsuarioMock);
    }

    @Test
    public void dadoQueCreoUnUsuarioMenorDe18AñosQueMeTireUsuarioNoValido() throws UsuarioNoValido {
       // preparacion
        Usuario usuario=new Usuario();
        usuario.setEmail("juan@example.com");
        usuario.setPassword("12345678");
        usuario.setEdad(17);
        // ejecucion y validacion
        UsuarioNoValido excepcion = assertThrows(UsuarioNoValido.class, () -> servicioLogin.validarNuevoUsuario(usuario));
        assertEquals("El usuario debe ser mayor de 18 años", excepcion.getMessage());
    }

    @Test
    public void dadoQueCreoUnUsuarioConNombreNuloQueMeTireUsuarioNoValido() throws UsuarioNoValido {
        // preparacion
         Usuario usuario=new Usuario();
         usuario.setEmail("juan@example.com");
         usuario.setPassword("12345678");
         usuario.setEdad(20);
         usuario.setNombre(null);
         // ejecucion y validacion
         UsuarioNoValido excepcion = assertThrows(UsuarioNoValido.class, () -> servicioLogin.validarNuevoUsuario(usuario));
         assertEquals("El nombre es obligatorio y no debe superar los 50 caracteres", excepcion.getMessage());
     }
   
    @Test
    public void dadoQueCreoUnUsuarioConNombreMayorA50CaracteresQueMeTireUsuarioNoValido() throws UsuarioNoValido {
        // preparacion
         Usuario usuario=new Usuario();
         usuario.setEmail("juan@example.com");
         usuario.setPassword("12345678");
         usuario.setEdad(20);
         usuario.setNombre("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
         // ejecucion y validacion
         UsuarioNoValido excepcion = assertThrows(UsuarioNoValido.class, () -> servicioLogin.validarNuevoUsuario(usuario));
         assertEquals("El nombre es obligatorio y no debe superar los 50 caracteres", excepcion.getMessage());
     }

     @Test
        public void dadoQueCreoUnUsuarioConDescripcionMayorA200CaracteresQueMeTireUsuarioNoValido() throws UsuarioNoValido {
            // preparacion
            Usuario usuario=new Usuario();
            usuario.setEmail("juan@example.com");
            usuario.setPassword("12345678");
            usuario.setEdad(20);
            usuario.setNombre("Juan");
            usuario.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            // ejecucion y validacion
            UsuarioNoValido excepcion = assertThrows(UsuarioNoValido.class, () -> servicioLogin.validarNuevoUsuario(usuario));
            assertEquals("La descripcion no debe superar los 200 caracteres", excepcion.getMessage());
        }
    @Test
    public void dadoQueCreoUnUsuarioSinEmailQueMeTireUsuarioNoValido() throws UsuarioNoValido {
        // preparacion
         Usuario usuario=new Usuario();
         usuario.setEdad(20);
         usuario.setPassword("12345678");
         usuario.setNombre("Juan");
         usuario.setEmail(null);
         // ejecucion y validacion
         UsuarioNoValido excepcion = assertThrows(UsuarioNoValido.class, () -> servicioLogin.validarNuevoUsuario(usuario));
         assertEquals("El email es obligatorio, debe ser valido y no debe superar los 100 caracteres", excepcion.getMessage());
     }

     @Test
    public void dadoQueCreoUnUsuarioConEmailInvalidoQueMeTireUsuarioNoValido() throws UsuarioNoValido {
        // preparacion
         Usuario usuario=new Usuario();
         usuario.setEdad(20);
         usuario.setNombre("Juan");
         usuario.setEmail("juanexample.com");
         usuario.setPassword("12345678");
         // ejecucion y validacion
         UsuarioNoValido excepcion = assertThrows(UsuarioNoValido.class, () -> servicioLogin.validarNuevoUsuario(usuario));
         assertEquals("El email es obligatorio, debe ser valido y no debe superar los 100 caracteres", excepcion.getMessage());
     }

     @Test
     public void dadoQueCreoUnUsuarioConEmailDeMasDe100CaracteresQueMeTireUsuarioNoValido() throws UsuarioNoValido {
         // preparacion
          Usuario usuario=new Usuario();
          usuario.setEdad(20);
          usuario.setNombre("Juan");
          usuario.setPassword("12345678");
          usuario.setEmail("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum@example.com");
            // ejecucion y validacion
            UsuarioNoValido excepcion = assertThrows(UsuarioNoValido.class, () -> servicioLogin.validarNuevoUsuario(usuario));
            assertEquals("El email es obligatorio, debe ser valido y no debe superar los 100 caracteres", excepcion.getMessage());
      }

      @Test
      public void dadoQueCreoUnUsuarioConPaswordNulaQueMeTireUsuarioNoValido() throws UsuarioNoValido {
          // preparacion
           Usuario usuario=new Usuario();
           usuario.setEdad(20);
           usuario.setNombre("Juan");
           usuario.setEmail("juan@example.com");
           usuario.setPassword(null);
           // ejecucion y validacion
           UsuarioNoValido excepcion = assertThrows(UsuarioNoValido.class, () -> servicioLogin.validarNuevoUsuario(usuario));
           assertEquals("La contraseña es obligatoria y debe tener al menos 8 caracteres", excepcion.getMessage());
       }
       @Test
       public void dadoQueCreoUnUsuarioConPasswordDeMenosDe8CaracteresQueMeTireUsuarioNoValido() throws UsuarioNoValido {
           // preparacion
            Usuario usuario=new Usuario();
            usuario.setEdad(20);
            usuario.setNombre("Juan");
            usuario.setEmail("juan@example.com");
            usuario.setPassword("1234567");
            // ejecucion y validacion
            UsuarioNoValido excepcion = assertThrows(UsuarioNoValido.class, () -> servicioLogin.validarNuevoUsuario(usuario));
            assertEquals("La contraseña es obligatoria y debe tener al menos 8 caracteres", excepcion.getMessage());
       }

    @Test
    public void dadoQueCreoUnUsuarioValidoQueMeDevuelvaTrue() throws UsuarioNoValido {
        // preparacion
        Usuario usuario = new Usuario();
        usuario.setEmail("juan@example.com");
        usuario.setNombre("Juan");
        usuario.setDescripcion("Descripcion valida");
        usuario.setEdad(20);
        usuario.setPassword("passwordValida");
        // ejecucion y validacion
        assertTrue(servicioLogin.validarNuevoUsuario(usuario));
    }

}

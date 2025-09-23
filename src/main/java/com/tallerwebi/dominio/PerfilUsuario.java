package com.tallerwebi.dominio;

import javax.persistence.*;

@Entity
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String avatar;   
    private String biografia;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public PerfilUsuario() {}

    public PerfilUsuario(String nombre, String avatar, String biografia) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.biografia = biografia;
    }

    public PerfilUsuario(String nombre, String avatar, String biografia, Usuario usuario) {
        this(nombre, avatar, biografia);
        this.usuario = usuario;
    }

    public Long getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getBiografia() { return biografia; }
    public void setBiografia(String biografia) { this.biografia = biografia; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}

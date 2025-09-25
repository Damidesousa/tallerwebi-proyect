package com.tallerwebi.dominio;

public class PerfilUsuario {
    private Long id;
    private Long usuarioId;
    private String nombre;
    private String biografia;
    private String avatarPath;
    private int seguidores;
    private int seguidos;

    public PerfilUsuario() { }

public PerfilUsuario(String nombre, String avatarPath, String biografia) {
    this.nombre = nombre;
    this.avatarPath = avatarPath;
    this.biografia = biografia;
}

public PerfilUsuario(Long usuarioId, String nombre, String avatarPath, String biografia) {
    this.usuarioId = usuarioId;
    this.nombre = nombre;
    this.avatarPath = avatarPath;
    this.biografia = biografia;
}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getBiografia() { return biografia; }
    public void setBiografia(String biografia) { this.biografia = biografia; }

    public String getAvatarPath() { return avatarPath; }
    public void setAvatarPath(String avatarPath) { this.avatarPath = avatarPath; }

    public int getSeguidores() { return seguidores; }
    public void setSeguidores(int seguidores) { this.seguidores = seguidores; }

    public int getSeguidos() { return seguidos; }
    public void setSeguidos(int seguidos) { this.seguidos = seguidos; }
}

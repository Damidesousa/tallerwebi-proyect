package com.tallerwebi.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hamburguesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private String descripcion;
    private double puntuacion;
    private Long idHamburgueseria;

    public Long getId() {return id;}
    
    public void setId(Long id) {this.id = id;}
    
    public String getNombre() {return nombre;}
    
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    public double getPrecio() {return precio;}
    
    public void setPrecio(double precio) {this.precio = precio;}
    
    public String getDescripcion() {return descripcion;}
    
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    
    public double getPuntuacion() {return puntuacion;}
    
    public void setPuntuacion(double puntuacion) {this.puntuacion = puntuacion;}
    
    public Long getIdHamburgueseria() {return idHamburgueseria;}

    public void setIdHamburgueseria(Long idHamburgueseria) {this.idHamburgueseria = idHamburgueseria;}
}

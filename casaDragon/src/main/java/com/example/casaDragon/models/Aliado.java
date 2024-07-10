package com.example.casaDragon.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tabla_aliado")
public class Aliado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "nombre_aliado", length = 50)
    private String nombre;
    @Column (name = "ubicacion_aliado")
    private String ubicacion;
    @Column (name = "aporte_aliado")
    private Double aporte;

    public Aliado() {
    }

    public Aliado(Integer id, String nombre, String ubicacion, Double aporte) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.aporte = aporte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getAporte() {
        return aporte;
    }

    public void setAporte(Double aporte) {
        this.aporte = aporte;
    }

}

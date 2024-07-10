package com.example.casaDragon.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tabla_dragon")
public class Dragon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "nombreDragon")
    private String nombre;

    @Column(name = "edad")
    private  Integer edad;

    @Column(name = "alturaDragon")
    private Double altura;

    @Column(name = "numeroVictorias")
    private Integer numeroVictorias;

    @OneToMany
    Jinete jinete;

    public Dragon() {
    }

    public Dragon(Integer numeroVictorias, String nombre, Integer id, Integer edad, Double altura) {
        this.numeroVictorias = numeroVictorias;
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.altura = altura;
    }

    public Integer getNumeroVictorias() {
        return numeroVictorias;
    }

    public void setNumeroVictorias(Integer numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
}

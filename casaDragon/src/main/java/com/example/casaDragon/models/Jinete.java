package com.example.casaDragon.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tabla_jinete")

public class Jinete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreJinete")
    private String nombre;

    @Column (name = "edadJinete")
    private Integer edad;

    @Column (name= "fechaMontura")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaMontura; // dia-mes-año

    @OneToMany(mappedBy = "jinete")
    @JsonManagedReference
    private List<Dragon> dragones;

    @OneToMany(mappedBy = "jinete")
    @JsonManagedReference
    private List<Aliado>aliados;


    public Jinete() {
    }

    public Jinete(Integer id, String nombre, Integer edad, LocalDate fechaMontura) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaMontura = fechaMontura;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaMontura() {
        return fechaMontura;
    }

    public void setFechaMontura(LocalDate fechaMontura) {
        this.fechaMontura = fechaMontura;
    }
}

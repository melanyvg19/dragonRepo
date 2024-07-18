package com.example.casaDragon.DTO;

public class JineteDTO {
    private String nombre;
    private Integer edad;

    public JineteDTO() {
    }

    public JineteDTO(Integer edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
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
}

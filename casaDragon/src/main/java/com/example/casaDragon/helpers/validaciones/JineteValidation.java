package com.example.casaDragon.helpers.validaciones;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class JineteValidation {
    public boolean validarNombresJinete(String nombreJinete) throws Exception{
        //20 caracteres
        if (nombreJinete.length()>20){
            return false;
        }

        //formato sea con letras y espacios, no números
        String expresionRegular="^[a-zA-Z\\s]+$";

        Pattern pattern = Pattern.compile(expresionRegular); // Convierte una cadena en patron
        Matcher coincidencia = pattern.matcher(nombreJinete); // Verifica que la cadena a validar cumpla el patron
        if (!coincidencia.matches()){
            return false;
        }
        return true;
    }
    public  boolean validarEdad(Integer edad){
        if (edad <=0 || edad >2000){
            return false;
        }
        return true;
    }
    public boolean validarFecha(LocalDate fechaMontura){
        // Expresión regular para validar el formato dd/MM/aa
        String expresionRegular = "^([0-2][0-9]|3[01])-(0[1-9]|1[0-2])-[0-9]{2}$";
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(fechaMontura.toString());

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }
}

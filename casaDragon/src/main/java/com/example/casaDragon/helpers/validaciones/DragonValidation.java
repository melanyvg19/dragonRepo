package com.example.casaDragon.helpers.validaciones;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component

public class DragonValidation {

    //métodos que ALICARAN LAS VALIDACIONES

    public boolean validarNombresDragon(String nombreDragon) throws Exception{
        //20 caracteres
        if (nombreDragon.length()>20){
           return false;
        }

        //formato sea con letras y espacios, no números
        String expresionRegular="^[a-zA-Z\\s]+$";

        Pattern pattern = Pattern.compile(expresionRegular); // Convierte una cadena en patron
        Matcher coincidencia = pattern.matcher(nombreDragon); // Verifica que la cadena a validar cumpla el patron
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

    public boolean validarAltura(Double altura){
        if (altura <=0){
            return false;
        }
        return true;
    }
    public boolean validarVictorias(Integer victorias){
        if (victorias < 0){
            return false;
        }
        return true;
    }
}

package com.example.casaDragon.helpers.validaciones;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AliadoValidation {
    public boolean validarNombresAliado(String nombreAliado) throws Exception{
        //20 caracteres
        if (nombreAliado.length()>20){
            return false;
        }

        //formato sea con letras y espacios, no números
        String expresionRegular="^[a-zA-Z\\s]+$";

        Pattern pattern = Pattern.compile(expresionRegular); // Convierte una cadena en patron
        Matcher coincidencia = pattern.matcher(nombreAliado); // Verifica que la cadena a validar cumpla el patron
        if (!coincidencia.matches()){
            return false;
        }
        return true;
    }
}

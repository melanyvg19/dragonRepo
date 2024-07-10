package com.example.casaDragon.servicios;

import com.example.casaDragon.models.Aliado;
import com.example.casaDragon.repositorios.AliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AliadoServicio {

    @Autowired
    AliadoServicio aliadoServicio;

    //agregarUnAliado

    public Aliado agregarAliado(Aliado datosAliado ) throws Exception{
        //llamar a las validaciones
        try{
            return AliadoRepository.save(datosAliado);

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}

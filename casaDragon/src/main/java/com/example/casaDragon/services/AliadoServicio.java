package com.example.casaDragon.services;

import com.example.casaDragon.helpers.MensajeServicios;
import com.example.casaDragon.helpers.validaciones.AliadoValidation;
import com.example.casaDragon.models.Aliado;
import com.example.casaDragon.repositories.AliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AliadoServicio {

    @Autowired
    AliadoRepository aliadoRepository;

    @Autowired
    AliadoValidation aliadoValidation;

    //agregarUnAliado

    public Aliado agregarAliado(Aliado datosAliado ) throws Exception{
        //llamar a las validaciones
        try{
            if (!aliadoValidation.validarNombresAliado(datosAliado.getNombre())){
                throw  new Exception("Revisa el nombre del aliado");
            }
            return aliadoRepository.save(datosAliado);

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscarTodosLosDragones

    public List<Aliado> buscarAliados() throws Exception {
        try{
            return aliadoRepository.findAll();

        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }
    public Aliado buscarAliadoPorId (Integer idAliado) throws  Exception {
        try{
            Optional<Aliado> aliadoEncontrado = aliadoRepository.findById(idAliado);
            if (aliadoEncontrado.isPresent()){
                return aliadoEncontrado.get();

            }else {
                throw new Exception(MensajeServicios.ALIADO_NO_ENCONTRADO.getMensaje());
            }
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
}

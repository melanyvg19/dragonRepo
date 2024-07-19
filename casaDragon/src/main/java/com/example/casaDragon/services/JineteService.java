package com.example.casaDragon.services;

import com.example.casaDragon.helpers.MensajeServicios;
import com.example.casaDragon.helpers.validaciones.JineteValidation;
import com.example.casaDragon.models.Jinete;
import com.example.casaDragon.repositories.JineteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JineteService {
    @Autowired
    JineteRepository jineteRepository;

    @Autowired
    JineteValidation jineteValidation;

    //agregarUnDragon

    public Jinete agregarJinete (Jinete datosJinete) throws Exception{
        //llamar a las validaciones
        try{
            if (!jineteValidation.validarNombresJinete(datosJinete.getNombre())){
                if (!jineteValidation.validarEdad(datosJinete.getEdad())){
                    if (!jineteValidation.validarFecha(datosJinete.getFechaMontura())){
                        throw  new Exception("Revisa la fecha de montura del aliado");
                    }
                    throw  new Exception("Revisa la edad del aliado");
                }
                throw  new Exception("Revisa el nombre del jinete");
            }
            return jineteRepository.save(datosJinete);

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //buscarTodosLosDragones

    public List<Jinete> buscarJinetes() throws Exception {
        try{
            return jineteRepository.findAll();

        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }
    //BuscarUnDragonById

    public  Jinete buscarJinetePorId(Integer idJinete) throws  Exception {
        try{
            Optional<Jinete> jineteEncontrado = jineteRepository.findById(idJinete);
            if (jineteEncontrado.isPresent()){
                return jineteEncontrado.get();

            }else {
                throw new Exception(MensajeServicios.JINETE_NO_ENCONTRADO.getMensaje());
            }
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
}

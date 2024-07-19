package com.example.casaDragon.services;

import com.example.casaDragon.DTO.DragonDTO;
import com.example.casaDragon.helpers.MensajeServicios;
import com.example.casaDragon.helpers.validaciones.DragonValidation;
import com.example.casaDragon.mapas.IMapaDragon;
import com.example.casaDragon.models.Dragon;
import com.example.casaDragon.repositories.DragonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DragonServicio {
    @Autowired
    DragonRepository dragonRepository;

    @Autowired
    IMapaDragon iMapaDragon;

    @Autowired
    DragonValidation dragonValidation;

    //agregarUnDragon
    public DragonDTO agregarDragon(Dragon datosDragon) throws Exception{
        //llamar a las validaciones
        try{

            if (!dragonValidation.validarNombresDragon(datosDragon.getNombres())){
                if (!dragonValidation.validarAltura(datosDragon.getAltura())){
                    if (!dragonValidation.validarEdad(datosDragon.getEdad())){
                        if (!dragonValidation.validarVictorias(datosDragon.getNumeroVictorias())){
                            throw new Exception("Revisa las victorias del dragon");
                        }
                        throw new Exception("Revisa la edad del dragon");
                    }
                    throw new Exception("Revisa la altura del dragon");
                }
                throw new Exception("Revisa el nombre del dragon");
            }
            return iMapaDragon.mapearDragon(dragonRepository.save(datosDragon));

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //buscarTodosDragones
    public List<DragonDTO> buscarDragones()throws Exception{
        try{
            return iMapaDragon.mapearListaDragones(dragonRepository.findAll());
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BuscarUnDragonLLavePrimaria
    public DragonDTO buscarDragonPorId(Integer idDrgon)throws Exception{
        try{

            Optional<Dragon>dragonEncontrado= dragonRepository.findById(idDrgon);
            if(dragonEncontrado.isPresent()){
                return iMapaDragon.mapearDragon(dragonEncontrado.get());
            }else{
                throw new Exception(MensajeServicios.DRAGON_NO_ENCONTRADO.getMensaje());
            }

        }
        catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //EditarInformacionDragon
    public DragonDTO modificarDragon(Integer idDragon, Dragon datosNuevosDragon) throws Exception{
        try{
            //Buscar el dragon que me van a editar
            Optional<Dragon> dragonEncontrado=dragonRepository.findById(idDragon);
            if(dragonEncontrado.isPresent()){
                //Traer los datos del dragon que estan en la BD
                Dragon dragon = dragonEncontrado.get();

                //Guardo los datos nuevos del dragon utilizando el mismo objeto
                dragon.setEdad(datosNuevosDragon.getEdad());
                return iMapaDragon.mapearDragon(dragonRepository.save(dragon));

            }else{
                throw new Exception(MensajeServicios.DRAGON_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //EliminarDragon
    public boolean eliminarDragon(Integer id)throws Exception{
        try{
            Optional<Dragon> dragonEncontrado=dragonRepository.findById(id);
            if(dragonEncontrado.isPresent()){
                dragonRepository.deleteById(id);
                return true;

            }else{
                throw new Exception(MensajeServicios.DRAGON_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw  new Exception(error.getMessage());
        }
    }
    //buscarUnDragonNombre

}

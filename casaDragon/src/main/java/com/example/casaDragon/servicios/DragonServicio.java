package com.example.casaDragon.servicios;

import com.example.casaDragon.models.Dragon;
import com.example.casaDragon.repositorios.DragonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DragonServicio {

    @Autowired
    DragonRespository dragonRespository;

    //agregarUnDragon

    public Dragon agregarDragon(Dragon datosDragon) throws Exception{
        //llamar a las validaciones
        try{
            return dragonRespository.save(datosDragon);

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //buscarTodosLosDragones

    public List<Dragon> buscarDragones() throws Exception {
        try{
            return dragonRespository.findAll();

        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }
    //BuscarUnDragonById
    //EditarIndoDeDragon
    //eliminarInfoDeDragon
}

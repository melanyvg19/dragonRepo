package com.example.casaDragon.controller;

import com.example.casaDragon.models.Aliado;
import com.example.casaDragon.services.AliadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("casadragonapi/v1/aliado")
public class AliadoController {
    //Se inyecta el servicio
    @Autowired
    AliadoServicio aliadoServicio;

    @PostMapping
    public ResponseEntity<?> guardarAliado(@RequestBody Aliado datosClienteAliado){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(aliadoServicio.agregarAliado(datosClienteAliado));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarAliados(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(aliadoServicio.buscarAliados());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    /*@GetMapping
    public ResponseEntity<?> buscarAliados(){
        return null;
    }*/

    @PutMapping
    public ResponseEntity<?> editareAliados(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarAliado(){
        return null;
    }

}



package com.example.casaDragon.controller;

import com.example.casaDragon.models.Jinete;
import com.example.casaDragon.services.JineteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("casadragonapi/v1/jinete")
public class JineteController {

        //Se inyecta el servicio
        @Autowired
        JineteService jineteService;

        @PostMapping
        public ResponseEntity<?> guardarJinete(@RequestBody Jinete datosClienteJinete){
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(jineteService.agregarJinete(datosClienteJinete));
            }catch (Exception error){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());
            }
        }

        @GetMapping
        public ResponseEntity<?> buscarJinetes(){
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(jineteService.buscarJinetes());
            }catch (Exception error){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());
            }
        }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDragon(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(jineteService.buscarJinetePorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

        @PutMapping
        public ResponseEntity<?> editarJinete(){
            return null;
        }

        @DeleteMapping
        public ResponseEntity<?> eliminarJinete(){
            return null;
        }

    }

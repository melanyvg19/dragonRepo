package com.example.casaDragon.controller;

import com.example.casaDragon.DTO.DragonDTO;
import com.example.casaDragon.models.Dragon;
import com.example.casaDragon.services.DragonServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("casadradoapi/v1/dragon")
@Tag(name="Servicios Dragon", description = "\nServicios asociados a la tabla dragon de la bd dragones, se hace CRUD completo")
public class  DragonController {

    //Inyecta el servicio
    @Autowired
    DragonServicio dragonServicio;

    @PostMapping
    @Operation(
            summary = "Registra un dragon nuevo en la base de datos",
            description = "al llevar nombres, edad, altura, se registra con éxito el dragon"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Dragon creado con exito en la BD",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DragonDTO.class),
                                    examples = @ExampleObject(value = "{\"nombres\":\"Lucerys Valeryon\",\"edad\":\"485\"}")
                            )
                    ),
                    @ApiResponse( responseCode = "400",
                            description = "Error al registrar el dragon",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class),
                                    examples = @ExampleObject(value = "{\"error\":\"Datos invalidos \"}")
                            ))
            }
    )
    public ResponseEntity<?> guardarDragon(@RequestBody Dragon datosClienteDragon){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(dragonServicio.agregarDragon(datosClienteDragon));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @GetMapping
    public ResponseEntity<?> buscarDragones(){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(dragonServicio.buscarDragones());

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDragon(@PathVariable Integer id){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(dragonServicio.buscarDragonPorId(id));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }

    }

    @PutMapping
    public ResponseEntity<?> editarDragon(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarDragon(){
        return null;
    }




}

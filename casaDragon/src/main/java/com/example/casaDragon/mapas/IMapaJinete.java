package com.example.casaDragon.mapas;

import com.example.casaDragon.DTO.JineteDTO;
import com.example.casaDragon.models.Jinete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaJinete {
    @Mappings({
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "edad", target = "edad")
    })
    public JineteDTO mapearDragon (Jinete jinete);
    public List<JineteDTO> mapearListaJinetes(List<Jinete> listaJinetes);
}

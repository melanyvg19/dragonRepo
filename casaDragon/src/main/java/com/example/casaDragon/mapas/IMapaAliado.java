package com.example.casaDragon.mapas;

import com.example.casaDragon.DTO.AliadoDTO;
import com.example.casaDragon.models.Aliado;
import com.example.casaDragon.models.Dragon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaAliado {
    @Mappings({
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "ubicacion", target = "ubicacion")
    })
    public AliadoDTO mapearAliado(Aliado aliado);
    public List<AliadoDTO> mapearListaAliados (List<Dragon> listaAliados);

}

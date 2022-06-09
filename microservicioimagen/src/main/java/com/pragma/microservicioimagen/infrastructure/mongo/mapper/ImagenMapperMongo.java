package com.pragma.microservicioimagen.infrastructure.mongo.mapper;

import com.pragma.microservicioimagen.domain.model.Imagen;
import com.pragma.microservicioimagen.infrastructure.mongo.entity.ImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImagenMapperMongo {
    @Autowired
    private ModelMapper modelMapper;

    // convert DTO to Entity
    public ImageEntity mapToEntity(Imagen imagen){
        return modelMapper.map(imagen,ImageEntity.class);
    }
    // convert entity to Model
    public Imagen mapToModel(ImageEntity imageEntity){
        return modelMapper.map(imageEntity, Imagen.class);
    }
}

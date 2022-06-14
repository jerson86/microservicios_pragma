package com.pragma.microservicioimagen.infrastructure;

import com.pragma.microservicioimagen.domain.model.Imagen;
import com.pragma.microservicioimagen.infrastructure.mongo.entity.ImageEntity;
import com.pragma.microservicioimagen.infrastructure.mongo.mapper.ImagenMapperMongo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class MapperTests {

    private ImageEntity imageEntity;

    private Imagen imagen;


    @Mock
    private ImagenMapperMongo imagenMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    void setUp()
    {

        imagen = new Imagen();
        imagen.setId("0");
        imagen.setFoto("hola.jpg");
        imagen.setIdImagen(2);

        imageEntity = new ImageEntity();
        imageEntity.setId("0");
        imageEntity.setFoto("hola.jpg");
        imageEntity.setIdImagen("2");
    }

    @Test
    void mapperToModelImagen(){
        //lenient().when(imagenMapperMysql.mapToModel(imagenEntity)).thenReturn(imagen);
        //lenient().when(modelMapper.map(imagenEntity,Imagen.class)).thenReturn(imagen);

        //Assertions.assertEquals(imagen, imagenMapperMysql.mapToModel(imagenEntity));
        //Assertions.assertEquals(imagen, modelMapper.map(imagenEntity,Imagen.class));

        //verify(imagenMapperMysql).mapToModel(imagenEntity);
        //verify(modelMapper).map(imagenEntity,Imagen.class);
    }
}

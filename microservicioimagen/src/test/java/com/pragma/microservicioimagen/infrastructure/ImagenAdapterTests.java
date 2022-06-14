package com.pragma.microservicioimagen.infrastructure;

import com.pragma.microservicioimagen.domain.model.Imagen;
import com.pragma.microservicioimagen.infrastructure.mongo.adapter.ImagenAdapter;
import com.pragma.microservicioimagen.infrastructure.mongo.adapter.NextSequenceAdapter;
import com.pragma.microservicioimagen.infrastructure.mongo.entity.ImageEntity;
import com.pragma.microservicioimagen.infrastructure.mongo.mapper.ImagenMapperMongo;
import com.pragma.microservicioimagen.infrastructure.mongo.repository.ImagenRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ImagenAdapterTests {

    private ImageEntity imageEntity;

    private Imagen imagen;

    @Mock
    private ImagenMapperMongo imagenMapper;

    @Mock
    private ImagenRepository imagenRepository;

    @Mock
    private NextSequenceAdapter nextSequenceService;

    @InjectMocks
    private ImagenAdapter imagenAdapter = new ImagenAdapter(imagenRepository);

    @BeforeEach
    void setUp()
    {

        imagen = new Imagen();
        imagen.setId(nextSequenceService.getNextSequence("imagenes"));
        imagen.setFoto("hola.jpg");
        imagen.setIdCliente(2);

        imageEntity = new ImageEntity();
        imageEntity.setId(nextSequenceService.getNextSequence("imagenes"));
        imageEntity.setFoto("hola.jpg");
        imageEntity.setIdCliente("2");

        Mockito.when(imagenRepository.findById("1")).thenReturn(Optional.of(imageEntity));
    }

    @DisplayName("JUnit test para el metodo createImagen")
    @Test
    void createImagenTest() {

        lenient().when(imagenRepository.save(imageEntity)).thenReturn(imageEntity);
        lenient().when(imagenMapper.mapToModel(imageEntity)).thenReturn(imagen);

        Assertions.assertEquals(imagen, imagenAdapter.save(imagen.getFoto(),"1"));

        verify(imagenMapper).mapToModel(imageEntity);
        verify(imagenRepository).save(imageEntity);
    }

    @Test
    void getAllImagenesTest()
    {
        when(imagenRepository.findAll()).thenReturn(List.of(imageEntity));
        when(imagenMapper.mapToModel(imageEntity)).thenReturn(imagen);

        Assertions.assertEquals(List.of(imagen), imagenAdapter.getAll());

        verify(imagenMapper).mapToModel(imageEntity);
        verify(imagenRepository).findAll();
    }

    @Test
    void getImagenByIdTest()
    {
        when(imagenRepository.findById("0")).thenReturn(Optional.ofNullable(imageEntity));
        when(imagenMapper.mapToModel(imageEntity)).thenReturn(imagen);

        Assertions.assertEquals(imagen, imagenAdapter.getById("0"));

        verify(imagenMapper).mapToModel(imageEntity);
        verify(imagenRepository).findById("0");
    }


    @Test
    void updateImagenTest()
    {
        when(imagenRepository.save(imageEntity)).thenReturn(imageEntity);
        when(imagenRepository.findById("0")).thenReturn(Optional.ofNullable(imageEntity));
        when(imagenMapper.mapToModel(imageEntity)).thenReturn(imagen);

        Assertions.assertEquals(imagen, imagenAdapter.update("0",imagen.getFoto(),"1"));

        verify(imagenMapper).mapToModel(imageEntity);
        verify(imagenRepository).findById("0");
        verify(imagenRepository).save(imageEntity);
    }

    @Test
    void deleteImagenTest()
    {
        when(imagenRepository.findById("0")).thenReturn(Optional.ofNullable(imageEntity));
        when(imagenMapper.mapToModel(imageEntity)).thenReturn(imagen);
        //when(imagenRepository.delete(imagen));

        Assertions.assertEquals(imagen, imagenAdapter.delete("0"));

        verify(imagenMapper).mapToModel(imageEntity);
        verify(imagenRepository).findById("0");
        verify(imagenRepository).delete(imageEntity);
    }
}

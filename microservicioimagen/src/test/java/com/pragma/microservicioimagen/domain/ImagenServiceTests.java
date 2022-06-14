package com.pragma.microservicioimagen.domain;

import com.pragma.microservicioimagen.domain.model.Imagen;
import com.pragma.microservicioimagen.domain.port.outbound.PersistImagen;
import com.pragma.microservicioimagen.domain.service.ImagenServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class ImagenServiceTests {

    private Imagen imagen;

    @Mock
    private PersistImagen persistImagen;

    @InjectMocks
    private ImagenServiceImpl imagenServiceImpl;

    @BeforeEach
    void setUp(){

        imagen = new Imagen();
        imagen.setId("1");
        imagen.setFoto("foto.jpg");
        imagen.setIdCliente(2);

        Mockito.when(persistImagen.getById("1")).thenReturn(imagen);
    }

    @Test
    void givenSaveImagenWhenIsNotNull(){
        lenient().when(imagenServiceImpl.createImage("foto.jpg","1")).thenReturn(imagen);
    }

    @Test
    void givenUpdateImagenWhenIsNotNull(){
        lenient().when(imagenServiceImpl.updateImagen("1","foto.jpg","1")).thenReturn(imagen);
    }

    @Test
    void givenDeleteImagenWhenIsNotNull(){
        lenient().when(imagenServiceImpl.deleteImagen("1")).thenReturn(imagen);
    }

    @Test
    void givenGetByIdImagenWhenIsNotNull(){
        lenient().when(imagenServiceImpl.getImagenById("1")).thenReturn(imagen);
    }

    @Test
    void givenGetAllmagenWhenIsNotNull(){
        lenient().when(imagenServiceImpl.getAllImages()).thenReturn(List.of(imagen));
    }
}

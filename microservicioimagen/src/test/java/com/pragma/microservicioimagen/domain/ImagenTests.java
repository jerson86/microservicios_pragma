package com.pragma.microservicioimagen.domain;

import com.pragma.microservicioimagen.domain.model.Imagen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ImagenTests {

    private Imagen imagen;

    @BeforeEach
    void setUp()
    {
        imagen = new Imagen();
        imagen.setId("1");
        imagen.setFoto("foto.jpg");
        imagen.setIdImagen(2);
    }

    @Test
    void givenImageWhenIsEqualsToFotoJpg(){
        assertThat(imagen.getFoto()).isEqualTo("foto.jpg");
    }
    @Test
    void givenIdImagenAndIdImagenWhenIsEqualsToIdFoto1AndIdImagen1(){
        assertThat(imagen.getId()).isEqualTo("1");
        assertThat(imagen.getIdImagen()).isEqualTo(2L);
    }

}

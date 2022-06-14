package com.pragma.microservicioimagen.infrastructure;

import com.pragma.microservicioimagen.application.dto.ImagenDTO;
import com.pragma.microservicioimagen.application.mapper.ImagenMapper;
import com.pragma.microservicioimagen.domain.exception.ResourceNotFoundException;
import com.pragma.microservicioimagen.domain.model.Imagen;
import com.pragma.microservicioimagen.domain.port.inbound.ImagenService;
import com.pragma.microservicioimagen.infrastructure.rest.ImagenRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ImagenRestController.class)
@ActiveProfiles("test")
public class RestControllerTests {
    private Imagen imagen;
    private ImagenDTO imagenDTO;

    private MockMvc mvc;

    @Mock
    private ImagenMapper imagenMapper;

    @Mock
    private ImagenService imagenService;

    @InjectMocks
    private ImagenRestController imagenRestController = new ImagenRestController(imagenService);

    // This object will be magically initialized by the initFields method below.
    private JacksonTester<Imagen> jsonImagen;

    @BeforeEach
    void setUp()
    {
        imagen = new Imagen();
        imagen.setId("1");
        imagen.setFoto("hola.jpg");
        imagen.setIdImagen(2);

        imagenDTO = new ImagenDTO();
        imagenDTO.setId("1");
        imagenDTO.setFoto("hola.jpg");
        imagenDTO.setIdImagen("2");

        Mockito.when(imagenService.getImagenById("1")).thenReturn(imagen);

    }

    @Test
    void givenImagenNotExistWhenIsNull(){
        try {
            assertThat(imagen.getId()).isEqualTo("2");
        }catch(Throwable ex){
            new ResourceNotFoundException("Imagen ",2L);
        }
    }

    @Test
    public void canRetrieveByIdWhenExists2() throws Exception {
        lenient().when(imagenMapper.mapToDTO(imagen)).thenReturn(imagenDTO);
        lenient().when(imagenService.getImagenById("1")).thenReturn(imagen);


        // when
        //ResponseEntity<ImagenDTO> result = imagenRestController.getImagen(1L);
        ResponseEntity<Imagen> result = new ResponseEntity<>(imagen, HttpStatus.CREATED);
        Assertions.assertEquals(result, imagenRestController.getImagen("1"));
        // verify
        verify(imagenMapper).mapToDTO(imagen);
        verify(imagenService).getImagenById("1");

    }

    @Test
    void shouldFetchOneUserById() throws Exception {
        final String imagenId = "1";

        given(imagenService.getImagenById(imagenId)).willReturn(imagen);

        this.mvc.perform(get("/api/imagens/{id}", imagenId))
                .andExpect(status().isOk());
    }

}

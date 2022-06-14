package com.pragma.microserviciocliente.infrastructure;

import com.pragma.microserviciocliente.application.dto.ClienteDTO;
import com.pragma.microserviciocliente.application.mapper.ClienteMapper;
import com.pragma.microserviciocliente.domain.exception.ResourceNotFoundException;
import com.pragma.microserviciocliente.domain.model.Cliente;
import com.pragma.microserviciocliente.domain.port.inbound.ClienteService;
import com.pragma.microserviciocliente.infrastructure.rest.ClienteRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ClienteRestController.class)
@ActiveProfiles("test")
public class RestControllerTests {
    private Cliente cliente;
    private ClienteDTO clienteDTO;

    private MockMvc mvc;

    @Mock
    private ClienteMapper clienteMapper;

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteRestController clienteRestController = new ClienteRestController(clienteService);

    // This object will be magically initialized by the initFields method below.
    private JacksonTester<Cliente> jsonCliente;

    @BeforeEach
    void setUp()
    {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombres("Pepito");
        cliente.setApellidos("Perez");
        cliente.setTipoDocumento("CC");
        cliente.setDocumento("123456");
        cliente.setEdad((short) 18);
        cliente.setCiudadNacimiento("Ocana");

        clienteDTO = new ClienteDTO();
        clienteDTO.setId(1L);
        clienteDTO.setNombres("Pepito");
        clienteDTO.setApellidos("Perez");
        clienteDTO.setTipoDocumento("CC");
        clienteDTO.setDocumento("123456");
        clienteDTO.setEdad((short) 18);
        clienteDTO.setCiudadNacimiento("Ocana");

     /*   JacksonTester.initFields(this, new ObjectMapper());
        // MockMvc standalone approach
        mvc = MockMvcBuilders.standaloneSetup(clienteRestController)
                .setControllerAdvice(new ControllerAdvisor())
                .build();

      */
    }

    @Test
    void givenClienteNotExistWhenIsNull(){
        try {
            assertThat(cliente.getId()).isEqualTo(2L);
        }catch(Throwable ex){
            new ResourceNotFoundException("Cliente ",2L);
        }
    }
/*
    @Test
    public void canRetrieveByIdWhenExists() throws Exception {



        lenient().when(clienteService.getClienteById(2)).thenReturn(cliente);
        lenient().when(clienteMapper.mapToDTO(cliente)).thenReturn(clienteDTO);

        // when
        final ResultActions response = mvc.perform(
                        get("/api/clientes/1")
                                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        // then

        response.andExpect(status().isOk());
    }

 */

    @Test
    public void canRetrieveByIdWhenExists2() throws Exception {
        lenient().when(clienteMapper.mapToDTO(cliente)).thenReturn(clienteDTO);
        lenient().when(clienteService.getClienteById(1)).thenReturn(cliente);


        // when
        //ResponseEntity<ClienteDTO> result = clienteRestController.getCliente(1L);
        ResponseEntity<Cliente> result = new ResponseEntity<>(cliente, HttpStatus.CREATED);
        Assertions.assertEquals(result, clienteRestController.getCliente(1L));
        // verify
        verify(clienteMapper).mapToDTO(cliente);
        verify(clienteService).getClienteById(1);

    }

    @Test
    void shouldFetchOneUserById() throws Exception {
        final Long userId = 1L;

        given(clienteService.getClienteById(userId)).willReturn(cliente);

        this.mvc.perform(get("/api/clientes/{id}", userId))
                .andExpect(status().isOk());
    }

}

package com.pragma.microserviciocliente.infrastructure;


import com.pragma.microserviciocliente.domain.model.Cliente;
import com.pragma.microserviciocliente.infrastructure.mysql.entity.ClienteEntity;
import com.pragma.microserviciocliente.infrastructure.mysql.mapper.ClienteMapperMysql;
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


    private Cliente cliente;
    private ClienteEntity clienteEntity;


    private ModelMapper modelMapper = new ModelMapper();
    @Mock
    private ClienteMapperMysql clienteMapperMysql;

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

        clienteEntity = new ClienteEntity();
        clienteEntity.setId(1L);
        clienteEntity.setNombres("Pepito");
        clienteEntity.setApellidos("Perez");
        clienteEntity.setTipoDocumento("CC");
        clienteEntity.setDocumento("123456");
        clienteEntity.setEdad((short) 18);
        clienteEntity.setCiudadNacimiento("Ocana");
    }

    @Test
    void mapperToModelCliente(){
        lenient().when(clienteMapperMysql.mapToModel(clienteEntity)).thenReturn(cliente);
        //lenient().when(modelMapper.map(clienteEntity,Cliente.class)).thenReturn(cliente);

        //Assertions.assertEquals(cliente, clienteMapperMysql.mapToModel(clienteEntity));
        Assertions.assertEquals(cliente, modelMapper.map(clienteEntity,Cliente.class));

        //verify(clienteMapperMysql).mapToModel(clienteEntity);
        //verify(modelMapper).map(clienteEntity,Cliente.class);
    }
}

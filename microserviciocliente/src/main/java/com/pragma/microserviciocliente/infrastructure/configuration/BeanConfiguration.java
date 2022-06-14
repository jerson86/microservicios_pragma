package com.pragma.microserviciocliente.infrastructure.configuration;


import com.pragma.microserviciocliente.MicroservicioclienteApplication;
import com.pragma.microserviciocliente.application.mapper.ClienteMapper;
import com.pragma.microserviciocliente.domain.port.inbound.ClienteService;
import com.pragma.microserviciocliente.domain.port.outbound.PersistCliente;
import com.pragma.microserviciocliente.domain.service.ClienteServiceImpl;
import com.pragma.microserviciocliente.infrastructure.mysql.mapper.ClienteMapperMysql;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = MicroservicioclienteApplication.class)
public class BeanConfiguration {
    @Bean
    ClienteService clienteService(final PersistCliente repository) {
        return new ClienteServiceImpl(repository);
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}

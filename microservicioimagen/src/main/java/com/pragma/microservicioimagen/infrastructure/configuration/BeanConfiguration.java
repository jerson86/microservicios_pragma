package com.pragma.microservicioimagen.infrastructure.configuration;

import com.pragma.microservicioimagen.MicroservicioimagenApplication;
import com.pragma.microservicioimagen.application.mapper.ImagenMapper;
import com.pragma.microservicioimagen.domain.port.inbound.ImagenService;
import com.pragma.microservicioimagen.domain.port.outbound.PersistImagen;
import com.pragma.microservicioimagen.domain.service.ImagenServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = MicroservicioimagenApplication.class)
public class BeanConfiguration {

    @Bean
    ImagenService imagenService(final PersistImagen repository) {
        return new ImagenServiceImpl(repository);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ImagenMapper imagenMapper(){
        return new ImagenMapper();
    }
}

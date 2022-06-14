package com.pragma.autenticacion.infrastructure.configuration;


import com.pragma.autenticacion.AutenticacionApplication;
import com.pragma.autenticacion.application.mapper.UserMapper;
import com.pragma.autenticacion.domain.port.inbound.UserService;
import com.pragma.autenticacion.domain.port.outbound.PersistUser;
import com.pragma.autenticacion.domain.service.UserServiceImpl;
import com.pragma.autenticacion.infrastructure.mysql.mapper.UserMapperMysql;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AutenticacionApplication.class)
public class BeanConfiguration {
    @Bean
    UserService userService(final PersistUser repository) {
        return new UserServiceImpl(repository);
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

    @Bean
    public UserMapperMysql userMapperMysql(){
        return new UserMapperMysql();
    }

}

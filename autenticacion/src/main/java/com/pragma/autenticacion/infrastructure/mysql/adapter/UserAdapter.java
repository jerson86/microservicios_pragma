package com.pragma.autenticacion.infrastructure.mysql.adapter;


import com.pragma.autenticacion.domain.exception.ResourceNotFoundException;
import com.pragma.autenticacion.domain.model.User;
import com.pragma.autenticacion.domain.port.outbound.PersistUser;
import com.pragma.autenticacion.infrastructure.mysql.entity.UserEntity;
import com.pragma.autenticacion.infrastructure.mysql.mapper.UserMapperMysql;
import com.pragma.autenticacion.infrastructure.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAdapter implements PersistUser {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapperMysql userMapperMysql;

    public UserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        List<UserEntity> usersEnt = userRepository.findAll();
        usersEnt.stream().findFirst().orElseThrow(()->
                new ResourceNotFoundException("user",1L)
        );
        // convert entity to DTO
        List<User> users= new ArrayList<>();
        usersEnt.forEach(user -> {
            User userResponse = userMapperMysql.mapToModel(user);
            users.add(userResponse);
        });

        return users;
    }

    @Override
    public User save(User user) {
        // convert DTO to Entity
        UserEntity userRequest = userMapperMysql.mapToEntity(user);
        userRepository.save(userRequest);
        // convert entity to DTO
        User userResponse = userMapperMysql.mapToModel(userRequest);
        return userResponse;
    }

    @Override
    public User update(User user, Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user",id));
        // convert DTO to Entity
        UserEntity userRequest = userMapperMysql.mapToEntity(user);
        userEntity.setId(id);
        userEntity.setNombres(userRequest.getNombres());
        userEntity.setApellidos(userRequest.getApellidos());
        userEntity.setEdad(userRequest.getEdad());
        userEntity.setCiudadNacimiento(userRequest.getCiudadNacimiento());
        userRepository.save(userEntity);
        // convert entity to DTO
        User userResponse = userMapperMysql.mapToModel(userEntity);
        return userResponse;
    }

    @Override
    public User delete(long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user",id));
        userRepository.delete(userEntity);
        // convert entity to DTO
        User userResponse = userMapperMysql.mapToModel(userEntity);
        return userResponse;
    }

    @Override
    public User getById(long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user",id));
        // convert entity to DTO
        User userResponse = userMapperMysql.mapToModel(userEntity);
        return userResponse;
    }

    @Override
    public User getByTipoDocumentoAndDocumento(String tipoDocumento, String documento) {
        UserEntity userEntity = userRepository.findByTipoDocumentoAndDocumento(tipoDocumento, documento).orElseThrow(()-> new ResourceNotFoundException("user",1L));
        // convert entity to DTO
        User userResponse = userMapperMysql.mapToModel(userEntity);
        return userResponse;
    }
}

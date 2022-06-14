package com.pragma.autenticacion.infrastructure.mysql.mapper;

import com.pragma.autenticacion.domain.model.User;
import com.pragma.autenticacion.infrastructure.mysql.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperMysql {
    @Autowired
    private ModelMapper modelMapper;

    // convert DTO to Entity
    public UserEntity mapToEntity(User user){
        return modelMapper.map(user,UserEntity.class);
    }
    // convert entity to Model
    public User mapToModel(UserEntity userEntity){
        return modelMapper.map(userEntity, User.class);
    }
}

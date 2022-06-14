package com.pragma.autenticacion.application.mapper;

import com.pragma.autenticacion.application.dto.UserDTO;
import com.pragma.autenticacion.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    // convert DTO to Entity
    public User mapToModel(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }
    // convert entity to DTO
    public UserDTO mapToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public List<User> mapToModelList(List<UserDTO> usersDTO){
        List<User> users= new ArrayList<>();
        usersDTO.forEach(user -> {
            User userResponse = this.mapToModel(user);
            users.add(userResponse);
        });
        return users;
    }

    public List<UserDTO> mapToDTOList(List<User> users){

        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> {
            UserDTO userResponse = this.mapToDTO(user);
            usersDTO.add(userResponse);
        });
        return usersDTO;
    }
}

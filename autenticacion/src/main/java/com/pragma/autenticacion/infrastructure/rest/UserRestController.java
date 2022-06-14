package com.pragma.autenticacion.infrastructure.rest;

import com.pragma.autenticacion.application.dto.UserDTO;
import com.pragma.autenticacion.application.mapper.UserMapper;
import com.pragma.autenticacion.domain.port.inbound.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private final UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers(){
       return  ResponseEntity.ok().body(
                userMapper.mapToDTOList(
                        userService.getAllUsers()
                )

        );
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        return ResponseEntity.ok().body(
            userMapper.mapToDTO(
                    userService.getUserById(id)
            )
        );
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(
                userMapper.mapToDTO(
                    userService.createUser(
                            userMapper.mapToModel(userDTO)
                    )
                ),
                HttpStatus.CREATED);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(
            userMapper.mapToDTO(
                userService.updateUser(
                    userMapper.mapToModel(userDTO), id
                )
            )
        );
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok().body(
                userMapper.mapToDTO(
                        userService.deleteUser(id)
                )
        );
    }
}

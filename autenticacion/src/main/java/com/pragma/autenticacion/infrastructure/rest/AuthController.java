package com.pragma.autenticacion.infrastructure.rest;

import com.pragma.autenticacion.application.dto.UserDTO;
import com.pragma.autenticacion.application.mapper.UserMapper;
import com.pragma.autenticacion.domain.port.inbound.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UserService userService;
    @Autowired
    private UserMapper userMapper;

    AuthenticationManager authenticationManager;
    @Autowired
    public AuthController(UserService userService, AuthenticationManager authenticationManager){
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    //@Autowired
    /*public AuthController(UserService userService) {
        this.userService = userService;
    }

     */

    @PostMapping("auth/login")
    public ResponseEntity<UserDTO> login(@RequestParam("user") String user, @RequestParam("password") String password){
        return ResponseEntity.ok().body(
                userMapper.mapToDTO(
                        userService.getUserById(id)
                )
        );
    }
}

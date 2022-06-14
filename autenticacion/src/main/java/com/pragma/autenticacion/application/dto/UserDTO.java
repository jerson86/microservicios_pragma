package com.pragma.autenticacion.application.dto;

import lombok.Data;


@Data
public class UserDTO {
    private long id;
    private String nombres;
    private  String apellidos;
    private String tipoDocumento;
    private String documento;
    private short edad;
    private String ciudadNacimiento;
}

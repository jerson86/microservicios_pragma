package com.pragma.autenticacion.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private long id;
    private String userName;
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private short edad;
    private String ciudadNacimiento;
}

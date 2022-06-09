package com.pragma.microserviciocliente.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {
    private long id;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private short edad;
    private String ciudadNacimiento;
}

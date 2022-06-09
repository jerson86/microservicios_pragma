package com.pragma.microservicioimagen.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Imagen {
    private String id;
    private String foto;
    private long idCliente;
}

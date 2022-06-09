package com.pragma.microservicioimagen.infrastructure.mongo.entity;

import jdk.jfr.Timestamp;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data
@Document(collection = "imagenes")
public class ImageEntity {
    @Id
    private String id;
    private String foto;
    private String idCliente;
    @Timestamp
    private Instant fechaRegistro;
    private int seq;
}

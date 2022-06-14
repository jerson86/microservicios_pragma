package com.pragma.microserviciocliente.infrastructure.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clientes")
public class ClienteEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @NonNull
        private String nombres;
        @NonNull
        private  String apellidos;
        private String tipoDocumento;
        private String documento;
        private short edad;
        private String ciudadNacimiento;
        @CreationTimestamp
        private Timestamp fechaRegistro;
}

package com.pragma.autenticacion.infrastructure.mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
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
        //@CreationTimestamp
        //private Instant fechaRegistro;
}

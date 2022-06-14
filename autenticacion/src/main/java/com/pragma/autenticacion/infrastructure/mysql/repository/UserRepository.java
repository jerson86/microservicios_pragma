package com.pragma.autenticacion.infrastructure.mysql.repository;

import com.pragma.autenticacion.infrastructure.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
}

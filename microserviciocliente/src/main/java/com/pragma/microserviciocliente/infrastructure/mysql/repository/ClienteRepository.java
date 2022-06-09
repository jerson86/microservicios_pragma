package com.pragma.microserviciocliente.infrastructure.mysql.repository;

import com.pragma.microserviciocliente.infrastructure.mysql.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
}

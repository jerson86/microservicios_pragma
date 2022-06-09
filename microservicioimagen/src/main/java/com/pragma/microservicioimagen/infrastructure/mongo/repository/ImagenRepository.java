package com.pragma.microservicioimagen.infrastructure.mongo.repository;

import com.pragma.microservicioimagen.infrastructure.mongo.entity.ImageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ImagenRepository extends MongoRepository<ImageEntity,String> {
    Optional<ImageEntity> findByIdCliente(long idCliente);
}

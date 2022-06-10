package com.pragma.microservicioimagen.infrastructure.mongo.adapter;

import com.pragma.microservicioimagen.domain.exception.ResourceNotFoundException;
import com.pragma.microservicioimagen.domain.model.Imagen;
import com.pragma.microservicioimagen.domain.port.outbound.PersistImagen;
import com.pragma.microservicioimagen.infrastructure.exception.ControllerAdvisor;
import com.pragma.microservicioimagen.infrastructure.exception.NoSuchElementFoundException;
import com.pragma.microservicioimagen.infrastructure.mongo.entity.ImageEntity;
import com.pragma.microservicioimagen.infrastructure.mongo.mapper.ImagenMapperMongo;
import com.pragma.microservicioimagen.infrastructure.mongo.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImagenAdapter implements PersistImagen {

    @Autowired
    private ImagenRepository imagenRepository;
    @Autowired
    private ImagenMapperMongo imagenMapperMongo;
    @Autowired
    private NextSequenceAdapter nextSequenceAdapter;

    @Autowired
    private RestTemplate template;

    private String utl = "http://localhost:8080";

    public ImagenAdapter(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    @Override
    public Imagen save(String foto, long idCliente) {

        ResponseEntity<String> responseCliente
                = template.getForEntity(utl + "/api/clientes/"+idCliente, String.class);

        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setId(nextSequenceAdapter.getNextSequence("imagenes"));
        imageEntity.setIdCliente(String.valueOf(idCliente));
        imageEntity.setFoto(foto);

        imagenRepository.save(imageEntity);
        // convert entity to Model
        Imagen imagenResponse = imagenMapperMongo.mapToModel(imageEntity);
        return imagenResponse;
    }

    @Override
    public Imagen update(String id, String foto, long idCliente) {
        ImageEntity imageEntity = imagenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("imagen",Long.parseLong(id)));
        imageEntity.setFoto(foto);
        imageEntity.setId(id);

        imagenRepository.save(imageEntity);
        // convert entity to DTO
        Imagen imagenResponse = imagenMapperMongo.mapToModel(imageEntity);

        return imagenResponse;
    }

    @Override
    public Imagen delete(String id) {
        ImageEntity imageEntity = imagenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("imagen",Long.parseLong(id)));
        imagenRepository.delete(imageEntity);
        // convert entity to DTO
        Imagen imagenResponse = imagenMapperMongo.mapToModel(imageEntity);
        return imagenResponse;
    }

    @Override
    public Imagen getById(String id) {
        ImageEntity imageEntity = imagenRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("imagen",Long.parseLong(id)));

        // convert entity to DTO
        Imagen imagenResponse = imagenMapperMongo.mapToModel(imageEntity);
        return imagenResponse;
    }

    @Override
    public List<Imagen> getAll() {
        List<ImageEntity> imagenesEnt = imagenRepository.findAll();
        imagenesEnt.stream().findFirst().orElseThrow(()->
                new ResourceNotFoundException("imagen",1L)
        );
        // convert entity to DTO
        List<Imagen> imagenes= new ArrayList<>();
        imagenesEnt.forEach(imagen -> {
            Imagen imagenResponse = imagenMapperMongo.mapToModel(imagen);
            imagenes.add(imagenResponse);
        });

        return imagenes;
    }
}

package com.pragma.microservicioimagen.domain.service;

import com.pragma.microservicioimagen.domain.model.Imagen;
import com.pragma.microservicioimagen.domain.port.inbound.ImagenService;
import com.pragma.microservicioimagen.domain.port.outbound.PersistImagen;

import java.util.List;

public class ImagenServiceImpl implements ImagenService {

    private final PersistImagen persistImagen;

    public ImagenServiceImpl(PersistImagen persistImagen) {
        this.persistImagen = persistImagen;
    }

    @Override
    public List<Imagen> getAllImages() {
        return persistImagen.getAll();
    }

    @Override
    public Imagen createImage(String foto, String idCiente) {

        return persistImagen.save(foto, idCiente);
    }

    @Override
    public Imagen updateImagen(String id, String foto, String idCiente) {
        return persistImagen.update(id,foto,idCiente);
    }

    @Override
    public Imagen deleteImagen(String id) {
        return persistImagen.delete(id);
    }

    @Override
    public Imagen getImagenById(String id) {
        return persistImagen.getById(id);
    }
}

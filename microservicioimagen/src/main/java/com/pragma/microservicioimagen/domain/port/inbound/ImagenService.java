package com.pragma.microservicioimagen.domain.port.inbound;

import com.pragma.microservicioimagen.domain.model.Imagen;

import java.util.List;

public interface ImagenService {
    List<Imagen> getAllImages();

    Imagen createImage(String foto, String idImagen);

    Imagen updateImagen(String id, String foto, String idCliente);

    Imagen deleteImagen(String id);

    Imagen getImagenById(String id);
}

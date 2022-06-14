package com.pragma.microservicioimagen.domain.port.outbound;

import com.pragma.microservicioimagen.domain.model.Imagen;

import java.util.List;

public interface PersistImagen {
    Imagen save(String foto, String idCliente);
    Imagen update(String id, String foto, String idCliente);
    Imagen delete(String id);
    Imagen getById(String id);
    List<Imagen> getAll();
}

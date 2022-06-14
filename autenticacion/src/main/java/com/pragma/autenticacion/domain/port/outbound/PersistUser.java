package com.pragma.autenticacion.domain.port.outbound;

import com.pragma.autenticacion.domain.model.User;

import java.util.List;

public interface PersistUser {
    User save(User user);
    User update(User user, Long id);
    User delete(long id);
    User getById(long id);
    List<User> getAll();
    User getByTipoDocumentoAndDocumento(String tipoDocumento, String documento);

}

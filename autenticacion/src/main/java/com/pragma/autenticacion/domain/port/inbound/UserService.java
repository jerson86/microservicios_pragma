package com.pragma.autenticacion.domain.port.inbound;

import com.pragma.autenticacion.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(User user, Long id);

    User deleteUser(long id);

    User getUserById(long id);

    User getByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
}

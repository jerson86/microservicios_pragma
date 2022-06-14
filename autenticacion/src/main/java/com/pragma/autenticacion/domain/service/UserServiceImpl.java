package com.pragma.autenticacion.domain.service;

import com.pragma.autenticacion.domain.model.User;
import com.pragma.autenticacion.domain.port.inbound.UserService;
import com.pragma.autenticacion.domain.port.outbound.PersistUser;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final PersistUser persistUser;

    public UserServiceImpl(PersistUser persistUser) {
        this.persistUser = persistUser;
    }

    @Override
    public List<User> getAllUsers() {
        return persistUser.getAll();
    }

    @Override
    public User createUser(User user) {
         persistUser.save(user);
         return user;
    }

    @Override
    public User updateUser(User user, Long id) {

        return persistUser.update(user,id);
    }

    @Override
    public User deleteUser(long id) {
        return persistUser.delete(id);
    }

    @Override
    public User getUserById(long id) {
        return persistUser.getById(id);
    }

    @Override
    public User getByTipoDocumentoAndDocumento(String tipoDocumento, String documento) {
        return persistUser.getByTipoDocumentoAndDocumento(tipoDocumento,documento);
    }
}

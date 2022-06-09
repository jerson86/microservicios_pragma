package com.pragma.microserviciocliente.domain.service;

import com.pragma.microserviciocliente.domain.model.Cliente;
import com.pragma.microserviciocliente.domain.port.inbound.ClienteService;
import com.pragma.microserviciocliente.domain.port.outbound.PersistCliente;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    private final PersistCliente persistCliente;

    public ClienteServiceImpl(PersistCliente persistCliente) {
        this.persistCliente = persistCliente;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return persistCliente.getAll();
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
         persistCliente.save(cliente);
         return cliente;
    }

    @Override
    public Cliente updateCliente(Cliente cliente, Long id) {

        return persistCliente.update(cliente,id);
    }

    @Override
    public Cliente deleteCliente(long id) {
        return persistCliente.delete(id);
    }

    @Override
    public Cliente getClienteById(long id) {
        return persistCliente.getById(id);
    }

    @Override
    public Cliente getByTipoDocumentoAndDocumento(String tipoDocumento, String documento) {
        return persistCliente.getByTipoDocumentoAndDocumento(tipoDocumento,documento);
    }
}

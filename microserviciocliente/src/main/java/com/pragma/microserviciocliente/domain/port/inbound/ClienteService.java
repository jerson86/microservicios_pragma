package com.pragma.microserviciocliente.domain.port.inbound;

import com.pragma.microserviciocliente.domain.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getAllClientes();

    Cliente createCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente, Long id);

    Cliente deleteCliente(long id);

    Cliente getClienteById(long id);

    Cliente getByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
}

package com.cliente.cliente.domain.repository;

import com.cliente.cliente.domain.Client;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getClient(String email);
    Client save (Client client);
    void delete(String email);
}

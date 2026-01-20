package com.cliente.cliente.persistence;

import com.cliente.cliente.domain.Client;
import com.cliente.cliente.domain.repository.ClientRepository;
import com.cliente.cliente.persistence.crud.SqlClientCrudRepository;
import com.cliente.cliente.persistence.entity.ClientEntity;
import com.cliente.cliente.persistence.mapper.ClientMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SqlClientRepository implements ClientRepository{

    @Autowired
    private SqlClientCrudRepository sqlClientCrudRepository;

    @Autowired
    private ClientMapper clientMapper;


    @Override
    public List<Client> getAll(){
        List<ClientEntity> clients = sqlClientCrudRepository.findAll();
        return clientMapper.toClients(clients);
    }

    @Override
    public Optional<Client> getClient(String email) {
        return sqlClientCrudRepository.findById(email).map(clientEntity -> clientMapper.toClient(clientEntity));
    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = clientMapper.toClientEntity(client);
        return clientMapper.toClient(sqlClientCrudRepository.save(clientEntity));
    }

    @Override
    public void delete(String email) {
        sqlClientCrudRepository.deleteById(email);
    }
}

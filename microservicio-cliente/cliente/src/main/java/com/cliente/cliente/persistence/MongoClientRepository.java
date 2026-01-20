package com.cliente.cliente.persistence;

import com.cliente.cliente.domain.Client;
import com.cliente.cliente.domain.repository.ClientRepository;
import com.cliente.cliente.persistence.crud.MongoClientCrudRepository;
import com.cliente.cliente.persistence.entity.ClientEntity;
import com.cliente.cliente.persistence.mapper.ClientMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoClientRepository implements ClientRepository{

    @Autowired
    private MongoClientCrudRepository mongoClientCrudRepository;

    @Autowired
    private ClientMapper clientMapper;


    @Override
    public List<Client> getAll(){
        List<ClientEntity> clients = mongoClientCrudRepository.findAll();
        return clientMapper.toClients(clients);
    }

    @Override
    public Optional<Client> getClient(String email) {
        return mongoClientCrudRepository.findById(email).map(clientEntity -> clientMapper.toClient(clientEntity));
    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = clientMapper.toClientEntity(client);
        return clientMapper.toClient(mongoClientCrudRepository.save(clientEntity));
    }

    @Override
    public void delete(String email) {
        mongoClientCrudRepository.deleteById(email);
    }
}

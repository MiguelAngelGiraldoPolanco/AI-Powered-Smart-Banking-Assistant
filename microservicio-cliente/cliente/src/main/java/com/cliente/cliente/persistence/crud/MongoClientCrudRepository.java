package com.cliente.cliente.persistence.crud;

import com.cliente.cliente.persistence.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoClientCrudRepository extends MongoRepository<ClientEntity,String> {
}

package com.cliente.cliente.persistence.crud;

import com.cliente.cliente.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlClientCrudRepository extends JpaRepository<ClientEntity,String>{
}

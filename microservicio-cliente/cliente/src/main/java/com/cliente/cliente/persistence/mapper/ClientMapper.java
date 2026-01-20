package com.cliente.cliente.persistence.mapper;

import com.cliente.cliente.domain.Client;
import com.cliente.cliente.persistence.entity.ClientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toClient(ClientEntity clientEntity);
    List<Client> toClients(List<ClientEntity> clientEntities);

    @InheritInverseConfiguration
    ClientEntity toClientEntity(Client client);
}

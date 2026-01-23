package com.cliente.cliente.persistence.mapper;

import com.cliente.cliente.domain.Client;
import com.cliente.cliente.persistence.entity.ClientEntity;
import com.cliente.cliente.web.dto.ClientRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    // Web -> Dominio (Para el POST)
    Client toDomain(ClientRequest clienteRequest);

    // Infra -> Dominio (Para el Get)
    Client toClient(ClientEntity clientEntity);
    List<Client> toClients(List<ClientEntity> clientEntities);

    // Dominio -> Infra (Para el SAVE)
    @InheritInverseConfiguration(name = "toClient")
    ClientEntity toClientEntity(Client client);

}

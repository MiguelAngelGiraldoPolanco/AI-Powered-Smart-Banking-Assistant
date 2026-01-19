package com.cliente.cliente.persistence.mapper;

import com.cliente.cliente.domain.Client;
import com.cliente.cliente.persistence.entity.ClientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // Aquí MapStruct mira el tipo de retorno y el parámetro
    Client toClient(ClientEntity clientEntity);

    @InheritInverseConfiguration
    ClientEntity toClientEntity(Client client);
}

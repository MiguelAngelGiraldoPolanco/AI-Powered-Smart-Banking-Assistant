package com.cliente.cliente.persistence.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "clientes")
public class ClientEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotNull
    @Field(name = "correo_electronico")
    private String email;

    @Field(name = "nombre")
    @NotNull
    private String name;

    @Field(name = "movil")
    @NotNull
    private String phone;

    public ClientEntity(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.cliente.cliente.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collation = "client")
public class ClientEntity {

    @Id
    @Field(name="correo_electronico")
    private String email;

    @Field(name = "nombre")
    private String name;

    @Field(name = "movil")
    private String phone;

    public ClientEntity(){

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

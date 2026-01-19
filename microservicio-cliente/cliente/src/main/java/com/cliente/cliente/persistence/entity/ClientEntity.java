package com.cliente.cliente.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="clients")
public class ClientEntity {

    @Id
    @Column(name="correo_electronico",nullable = false)
    private String email;

    @Column(name = "nombre", nullable = false, length = 200)
    private String name;

    @Column(name = "movil", nullable = false, length = 11)
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

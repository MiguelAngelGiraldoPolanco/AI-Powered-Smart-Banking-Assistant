package com.cliente.cliente.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientRequest {

    private String id;

    @NotBlank(message = "El email no puede estar en blanco")
    @Email(message = "El formato del email es incorrecto")
    private String email;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, message = "El nombre debe tener al menos 2 letras")
    private String name;

    @NotBlank(message = "El movil no puede estar en blanco")
    @Size(min = 9, max = 12, message = "Debe tener los numeros completos")
    private String phone;

    public String getId(){return id;}

    public void setId(String id){this.id=id;}

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

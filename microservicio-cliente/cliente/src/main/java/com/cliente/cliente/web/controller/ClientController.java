package com.cliente.cliente.web.controller;

import com.cliente.cliente.domain.Client;
import com.cliente.cliente.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll(){
        List<Client> clients = clientService.getAll();
        return ResponseEntity.ok(clients != null ? clients : new ArrayList<>());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Client> getClient(@PathVariable("email") String email){
        return clientService.getClient(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Client> save(@RequestBody Client client){
        Client savedClient = clientService.save(client);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(savedClient.getEmail())
                .toUri();
        return ResponseEntity.created(location).body(savedClient);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> delete(@PathVariable("email") String email){
        return clientService.delete(email)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}

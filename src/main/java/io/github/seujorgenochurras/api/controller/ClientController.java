package io.github.seujorgenochurras.api.controller;

import io.github.seujorgenochurras.api.assemble.ClientDtoAssembler;
import io.github.seujorgenochurras.api.dto.ClientDto;
import io.github.seujorgenochurras.api.dto.ClientRegisterDto;
import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.service.ClientService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(path =  "/register/client")
    public ResponseEntity<Client> registerClient(
            @RequestBody @Validated @NotNull ClientRegisterDto registerDto) {

        Client client = ClientDtoAssembler.assembleRegistration(registerDto);
        client.setId(UUID.randomUUID().toString());

        clientService.save(client);

        return new ResponseEntity<>(client, HttpStatusCode.valueOf(201));
    }

    @RequestMapping("search/client")
    public ResponseEntity<List<Client>> searchClients(){
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }



}

package io.github.seujorgenochurras.api.controller;

import io.github.seujorgenochurras.api.assemble.ClientDtoAssembler;
import io.github.seujorgenochurras.api.assemble.ProductOrderAssembler;
import io.github.seujorgenochurras.api.dto.ClientRegisterDto;
import io.github.seujorgenochurras.api.dto.ProductOrderDto;
import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.model.ProductOrder;
import io.github.seujorgenochurras.domain.service.ClientService;
import io.github.seujorgenochurras.domain.service.ProductService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductOrderAssembler productOrderAssembler;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientDtoAssembler clientDtoAssembler;

    @RequestMapping(path =  "/register/client")
    public ResponseEntity<Client> registerClient(
            @RequestBody @Validated @NotNull ClientRegisterDto registerDto) {

        Client client = clientDtoAssembler.assembleRegistration(registerDto);

        clientService.save(client);

        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }


    @RequestMapping(path = "client/buy")
    @PostMapping
    public ResponseEntity<ProductOrder> orderProduct(@RequestBody ProductOrderDto productOrderDto){
        ProductOrder productOrder = productOrderAssembler.assemble(productOrderDto);


        return new ResponseEntity<>(productOrder, HttpStatus.CREATED);
    }

    @GetMapping(path = "search/client")
    public ResponseEntity<List<Client>> searchClients(){
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }



}

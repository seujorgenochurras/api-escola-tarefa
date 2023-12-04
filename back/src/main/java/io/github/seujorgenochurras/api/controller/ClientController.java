package io.github.seujorgenochurras.api.controller;

import io.github.seujorgenochurras.api.assemble.ClientDtoAssembler;
import io.github.seujorgenochurras.api.assemble.ProductOrderAssembler;
import io.github.seujorgenochurras.api.dto.*;
import io.github.seujorgenochurras.api.util.HashUtil;
import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.model.ClientAddress;
import io.github.seujorgenochurras.domain.model.ClientInfo;
import io.github.seujorgenochurras.domain.model.ProductOrder;
import io.github.seujorgenochurras.domain.service.ClientAddressService;
import io.github.seujorgenochurras.domain.service.ClientService;
import io.github.seujorgenochurras.domain.service.ProductOrderService;
import io.github.seujorgenochurras.domain.service.ProductService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
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

    @Autowired
    private ClientAddressService clientAddressService;

    @Autowired
    private ProductOrderService productOrderService;

    @PostMapping(path = "/register/client/address")
    public ResponseEntity<Object> registerAddress(@RequestBody @Validated ClientAddressRegisterDto clientAddressRegisterDto) {
        ClientAddress persistedAddress = clientService.registerAddress(clientAddressRegisterDto);
        if(persistedAddress == null){
            return new ResponseEntity<>("Cliente não encontrado", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(persistedAddress, HttpStatus.CREATED);
    }

    @PostMapping(path = "/client/info")
    public ResponseEntity<Object> getClientInfo(@RequestBody String clientToken) {
        ClientInfo persistedInfo = clientService.getClientInfo(clientToken);
        if (persistedInfo == null) {
            return new ResponseEntity<>("Não há informações cadastradas para esse usuario", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(persistedInfo, HttpStatus.OK);
    }

    @PostMapping(path = "/register/client/info")
    public ResponseEntity<Object> registerClientInfo(@RequestBody @Validated @NotNull
                                                     RegisterInfoDto registerInfoDto) {

        ClientInfo persistedClientInfo = clientService.registerInfo(registerInfoDto);
        if (persistedClientInfo == null) {
            return new ResponseEntity<>("Usuario não encontrado", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(persistedClientInfo, HttpStatus.CREATED);

    }

    @PostMapping(path = "/register/client")
    public ResponseEntity<Object> registerClient(
            @RequestBody @Validated @NotNull ClientRegisterDto registerDto) {

        Client client = clientDtoAssembler.assembleRegistration(registerDto);

        Client persistedClient = clientService.register(client);
        if (persistedClient == null) {
            return new ResponseEntity<>("Usuario já existente", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }


    @PostMapping(path = "client/buy")
    public ResponseEntity<ProductOrder> orderProduct(@RequestBody ProductOrderDto productOrderDto) {
        ProductOrder productOrder = productOrderAssembler.assemble(productOrderDto);

        productOrderService.save(productOrder);

        return new ResponseEntity<>(productOrder, HttpStatus.CREATED);
    }

    @PostMapping(path = "client/orders")
    public ResponseEntity<List<ProductOrder>> getClientOrders(@RequestBody String clientToken) {
        return new ResponseEntity<>(productOrderService.getClientOrders(clientToken), HttpStatus.OK);
    }

    @GetMapping(path = "search/client")
    public ResponseEntity<List<Client>> searchClients() {
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping(path = "client/account")
    public ResponseEntity<Object> getClientAccountInfo(@RequestBody String clientToken) {
        Client client = clientService.getClientAccountInfo(clientToken);
        if (client == null) {
            return new ResponseEntity<>("Algo de errado aconteceu!", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping(path = "login/client")
    public ResponseEntity<String> loginClient(@RequestBody ClientLoginDto clientLoginDto) {

        String clientToken = HashUtil.toSHA1(
                (clientLoginDto.getUsername() + clientLoginDto.getPassword()).getBytes(StandardCharsets.UTF_8));

        //TODO This is bad, not good. I'm so sorry to whoever put an actual password here
        Client loggedInClient = clientService.findClientByToken(clientToken);

        if (loggedInClient == null) {
            return new ResponseEntity<>("Senha ou usúario estão inválidos", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(clientToken, HttpStatus.OK);
    }


}

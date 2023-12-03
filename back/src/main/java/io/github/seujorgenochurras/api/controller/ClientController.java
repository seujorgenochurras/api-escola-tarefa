package io.github.seujorgenochurras.api.controller;

import io.github.seujorgenochurras.api.assemble.ClientDtoAssembler;
import io.github.seujorgenochurras.api.assemble.ProductOrderAssembler;
import io.github.seujorgenochurras.api.dto.ClientLoginDto;
import io.github.seujorgenochurras.api.dto.ClientRegisterDto;
import io.github.seujorgenochurras.api.dto.ProductOrderDto;
import io.github.seujorgenochurras.api.util.HashUtil;
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

    @RequestMapping(path = "/register/client")
    public ResponseEntity<Object> registerClient(
            @RequestBody @Validated @NotNull ClientRegisterDto registerDto) {

        Client client = clientDtoAssembler.assembleRegistration(registerDto);

        Client persistedClient = clientService.register(client);
        if(persistedClient == null){
            return new ResponseEntity<>("Usuario já existente", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }


    @RequestMapping(path = "client/buy")
    @PostMapping
    public ResponseEntity<ProductOrder> orderProduct(@RequestBody ProductOrderDto productOrderDto) {
        ProductOrder productOrder = productOrderAssembler.assemble(productOrderDto);


        return new ResponseEntity<>(productOrder, HttpStatus.CREATED);
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
        Client loggedInClient = clientService.login(clientToken);

        if (loggedInClient == null) {
            return new ResponseEntity<>("Senha ou usúario estão inválidos", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(clientToken, HttpStatus.OK);
    }


}

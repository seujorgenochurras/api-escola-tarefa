package io.github.seujorgenochurras.api.controller;

import io.github.seujorgenochurras.api.assemble.ClientDtoAssembler;
import io.github.seujorgenochurras.api.dto.ClientRegisterDto;
import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.model.Seller;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SellerController {

    public ResponseEntity<Seller> registerClient(
            @RequestBody @Validated @NotNull ClientRegisterDto registerDto) {

        Seller seller = SellerDtoAssembler.assembleRegistration(registerDto);
        client.setId(UUID.randomUUID().toString());
        return new ResponseEntity<>(client, HttpStatusCode.valueOf(201));
    }
}

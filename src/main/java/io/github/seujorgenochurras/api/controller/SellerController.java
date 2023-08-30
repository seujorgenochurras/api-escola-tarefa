package io.github.seujorgenochurras.api.controller;

import io.github.seujorgenochurras.api.assemble.SellerDtoAssembler;
import io.github.seujorgenochurras.api.dto.SellerRegisterDto;
import io.github.seujorgenochurras.domain.model.Seller;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SellerController {

    public ResponseEntity<Object> registerSeller(SellerRegisterDto sellerDto){
        Seller seller = SellerDtoAssembler.assembleRegistrationDto(sellerDto);
        seller.setId(UUID.randomUUID().toString());

        return new ResponseEntity<>(seller, HttpStatusCode.valueOf(203));
    }

}

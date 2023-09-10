package io.github.seujorgenochurras.api.controller;

import io.github.seujorgenochurras.api.assemble.SellerDtoAssembler;
import io.github.seujorgenochurras.api.dto.SellerRegisterDto;
import io.github.seujorgenochurras.domain.model.Seller;
import io.github.seujorgenochurras.domain.service.SellerService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping("register/seller")
    public ResponseEntity<Seller> registerSeller(SellerRegisterDto sellerDto){
        Seller seller = SellerDtoAssembler.assembleRegistrationDto(sellerDto);
        seller.setId(UUID.randomUUID().toString());
        sellerService.save(seller);
        return new ResponseEntity<>(sellerService.save(seller), HttpStatus.CREATED);
    }

    @RequestMapping("search/seller")
    public ResponseEntity<List<Seller>> searchSellers(){
        return new ResponseEntity<>(sellerService.getAllSellers(), HttpStatus.OK);
    }

}

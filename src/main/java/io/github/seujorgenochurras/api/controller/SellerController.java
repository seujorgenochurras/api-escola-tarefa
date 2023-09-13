package io.github.seujorgenochurras.api.controller;

import io.github.seujorgenochurras.api.assemble.SellerDtoAssembler;
import io.github.seujorgenochurras.api.dto.ProductDto;
import io.github.seujorgenochurras.api.dto.SellerRegisterDto;
import io.github.seujorgenochurras.domain.model.Product;
import io.github.seujorgenochurras.domain.model.Seller;
import io.github.seujorgenochurras.domain.service.ProductService;
import io.github.seujorgenochurras.domain.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SellerDtoAssembler sellerDtoAssembler;

    @Autowired
    private ProductService productService;

    @RequestMapping("register/seller")
    public ResponseEntity<Seller> registerSeller(SellerRegisterDto sellerDto){
        Seller seller = sellerDtoAssembler.assembleRegistrationDto(sellerDto);
        seller = sellerService.save(seller);

        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

    @RequestMapping("search/seller")
    public ResponseEntity<List<Seller>> searchSellers(){
        return new ResponseEntity<>(sellerService.getAllSellers(), HttpStatus.OK);
    }

    @RequestMapping("seller/sell")
    @PutMapping
    public ResponseEntity<Product> sellProduct(@RequestBody String productUUID){
        Product product = productService.findById(productUUID);
        product.setOnSale(true);
        product = productService.updateProduct(product);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}

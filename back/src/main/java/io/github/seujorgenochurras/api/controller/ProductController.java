package io.github.seujorgenochurras.api.controller;

import io.github.seujorgenochurras.api.assemble.ProductAssembler;
import io.github.seujorgenochurras.api.dto.ProductDto;
import io.github.seujorgenochurras.domain.model.Product;
import io.github.seujorgenochurras.domain.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductAssembler productAssembler;

    @Autowired
    private ProductService productService;


    @PostMapping(path = "/register/product")
    public ResponseEntity<Product> registerProduct(@RequestBody @Valid ProductDto productDto){
        Product product = productAssembler.toEntity(productDto);
        productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}

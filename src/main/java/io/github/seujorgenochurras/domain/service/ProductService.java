package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.api.dto.ProductDto;
import io.github.seujorgenochurras.domain.model.Product;
import io.github.seujorgenochurras.domain.repository.ProductRepository;
import io.github.seujorgenochurras.domain.service.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product save(Product product){
        product.setId(UUID.randomUUID().toString());
        System.out.println(product);
        return productRepository.save(product);
    }

    @Transient
    public Product updateProduct(@Valid Product product){
        String productId = product.getId();
        productRepository.deleteById(productId);

        return productRepository.save(product);
    }

    public Product findById(String uuid){
        return productRepository.findById(uuid).orElseThrow(() ->
                new NotFoundException("Product '" + uuid + "' not found!"));
    }


}

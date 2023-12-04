package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.domain.model.Product;
import io.github.seujorgenochurras.domain.repository.ProductRepository;
import io.github.seujorgenochurras.domain.service.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllActiveProducts() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transient
    public Product updateProduct(@Valid Product product) {
        Integer productId = product.getId();
        productRepository.deleteById(productId);

        return productRepository.save(product);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product '" + id + "' not found!"));
    }

}

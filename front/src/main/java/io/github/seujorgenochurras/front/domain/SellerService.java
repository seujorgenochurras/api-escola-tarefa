package io.github.seujorgenochurras.front.domain;


import io.github.seujorgenochurras.front.dto.ProductDto;
import io.github.seujorgenochurras.front.service.ProductService;
import io.github.seujorgenochurras.front.util.FXMLLoaderUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

//I hate this hack, but It'll have to work for now
public class SellerService {
    SellerService() {

    }

    public ObservableList<Product> getSellerProductsAsObservable() {
        ObservableList<ProductDto> productDtos = new ProductService().getProducts();
        ObservableList<Product> parsedProductsCollection = FXCollections.observableArrayList();
        for (ProductDto productDto : productDtos) {
            parsedProductsCollection.add(new Product()
                    .setName(productDto.getName())
                    .setDescription(productDto.getDescription())
                    .setPrice(productDto.getPrice())
                    .setDescription(productDto.getDescription())
                    .setCategory(productDto.getCategory()));
        }
        return parsedProductsCollection;
    }

    public List<ProductDto> getAllProducts() {
        //TODO API CALL
        return new ProductService().getProducts();

    }
}

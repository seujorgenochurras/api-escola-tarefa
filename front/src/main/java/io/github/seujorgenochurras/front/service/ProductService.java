package io.github.seujorgenochurras.front.service;

import io.github.seujorgenochurras.front.dto.ProductDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductService {

    public boolean registerProduct(ProductDto productDto){
        //TODO
        return false;
    }
    public ObservableList<ProductDto> getProducts(){
        ObservableList<ProductDto> products = FXCollections.observableArrayList();
        products.add(new ProductDto()
                .setName("Tomate")
                .setCategory("Fruta")
                .setPrice(1301.10)
                .setDescription("Comida vermelha"));
        products.add(new ProductDto()
                .setName("Tomate123")
                .setCategory("123123123123123")
                .setPrice(1201.10)
                .setDescription("Comida Azzul"));
        products.add(new ProductDto()
                .setName("Tomate3")
                .setCategory("Fruta")
                .setPrice(11.10)
                .setDescription("vermelha"));
        products.add(new ProductDto()
                .setName("Tomate2")
                .setCategory("MIHA PIKA")
                .setPrice(1.10)
                .setDescription("Comida ROXA"));
        products.add(new ProductDto()
                .setName("Tomate")
                .setCategory("Fruta")
                .setPrice(1301.10)
                .setDescription("Comida vermelha"));
        products.add(new ProductDto()
                .setName("Tomate123")
                .setCategory("123123123123123")
                .setPrice(1201.10)
                .setDescription("Comida Azzul"));
        products.add(new ProductDto()
                .setName("Tomate3")
                .setCategory("Fruta")
                .setPrice(11.10)
                .setDescription("vermelha"));
        products.add(new ProductDto()
                .setName("Tomate2")
                .setCategory("MIHA PIKA")
                .setPrice(1.10)
                .setDescription("Comida ROXA"));

        return products;
    }
}

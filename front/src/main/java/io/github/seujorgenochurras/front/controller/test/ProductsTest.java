package io.github.seujorgenochurras.front.controller.test;

import io.github.seujorgenochurras.front.dto.ProductDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ProductsTest {
    public static ObservableList<ProductDto> products = FXCollections.observableArrayList();

    static {
        getProducts();
    }

    private static ObservableList<ProductDto> getProducts(){
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

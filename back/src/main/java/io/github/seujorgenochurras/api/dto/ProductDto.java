package io.github.seujorgenochurras.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDto {
    @NotNull
    @Size(max = 200)
    private String name;

    @NotNull
    private String seller;

    @NotNull
    private double price;

    @NotNull
    private String description;


    public String getDescription() {
        return description;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public ProductDto setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductDto setPrice(double price) {
        this.price = price;
        return this;
    }

}

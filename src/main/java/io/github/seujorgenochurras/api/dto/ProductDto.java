package io.github.seujorgenochurras.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDto {
    @NotNull
    @Size(max = 200)
    private String name;

    @NotNull
    private int stock;

    @Size(max = 36)
    @NotNull
    private String seller;

    @NotNull
    private double price;

    @NotNull
    @Size(max = 30)
    private String country;

    @NotNull
    @Column(name = "quantity", precision = 3)
    private double minimalQuantity;

    @NotNull
    @Size(max = 3)
    private String quantifiedAs;

    @NotNull
    private String description;


    public String getDescription() {
        return description;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getStock() {
        return stock;
    }

    public ProductDto setStock(int stock) {
        this.stock = stock;
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

    public String getCountry() {
        return country;
    }

    public ProductDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public double getMinimalQuantity() {
        return minimalQuantity;
    }

    public ProductDto setMinimalQuantity(double minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
        return this;
    }

    public String getQuantifiedAs() {
        return quantifiedAs;
    }

    public ProductDto setQuantifiedAs(String quantifiedAs) {
        this.quantifiedAs = quantifiedAs;
        return this;
    }
}

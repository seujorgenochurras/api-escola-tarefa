package io.github.seujorgenochurras.api.dto;

public class RegisterProductDto {
    private String name;
    private String sellerId;
    private double price;
    private double quantity;
    private String quantifiedAs;
    private String country;
    private String description;

    public String getName() {
        return name;
    }

    public RegisterProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSellerId() {
        return sellerId;
    }

    public RegisterProductDto setSellerId(String sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public RegisterProductDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getQuantity() {
        return quantity;
    }

    public RegisterProductDto setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getQuantifiedAs() {
        return quantifiedAs;
    }

    public RegisterProductDto setQuantifiedAs(String quantifiedAs) {
        this.quantifiedAs = quantifiedAs;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public RegisterProductDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RegisterProductDto setDescription(String description) {
        this.description = description;
        return this;
    }
}

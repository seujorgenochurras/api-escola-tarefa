package io.github.seujorgenochurras.api.dto;

public class ProductOrderDto {
    private String client;

    private String product;

    private int amount;


    public String getClient() {
        return client;
    }

    public ProductOrderDto setClient(String client) {
        this.client = client;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public ProductOrderDto setProduct(String product) {
        this.product = product;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ProductOrderDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}

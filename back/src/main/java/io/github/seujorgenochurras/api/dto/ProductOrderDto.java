package io.github.seujorgenochurras.api.dto;

import io.github.seujorgenochurras.domain.model.Address;

public class ProductOrderDto {
    private String client;

    //TODO just to let you know, you can get this by going into product :p (bruh)
    private String seller;

    private Integer product;

    private AddressDto address;

    private int amount;

    public String getSeller() {
        return seller;
    }

    public ProductOrderDto setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public String getClient() {
        return client;
    }

    public ProductOrderDto setClient(String client) {
        this.client = client;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public ProductOrderDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public Integer getProduct() {
        return product;
    }

    public ProductOrderDto setProduct(Integer product) {
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

package io.github.seujorgenochurras.api.dto;

import io.github.seujorgenochurras.domain.model.Address;
import jakarta.validation.constraints.NotNull;

public class SellerRegisterDto {
    @NotNull
    private String name;

    @NotNull
    private Address address;

    public String getName() {
        return name;
    }

    public SellerRegisterDto setName(String name) {
        this.name = name;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public SellerRegisterDto setAddress(Address address) {
        this.address = address;
        return this;
    }
}

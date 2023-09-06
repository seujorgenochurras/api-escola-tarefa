package io.github.seujorgenochurras.api.dto;

import io.github.seujorgenochurras.domain.model.Address;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;

public class SellerRegisterDto {
    @NotNull
    private String name;
    @NotNull
    @Embedded
    private Address address;
    @NotNull
    private int age;

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

    public int getAge() {
        return age;
    }

    public SellerRegisterDto setAge(int age) {
        this.age = age;
        return this;
    }
}

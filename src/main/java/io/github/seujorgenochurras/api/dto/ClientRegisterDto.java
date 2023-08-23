package io.github.seujorgenochurras.api.dto;

import io.github.seujorgenochurras.domain.model.Address;
import io.github.seujorgenochurras.domain.model.Gender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class ClientRegisterDto {
    @NotNull
    private String name;
    @NotNull
    private Gender gender;
    @NotNull
    private int age;
    @NotNull
    @Valid
    private Address address;

    public String getName() {
        return name;
    }

    public ClientRegisterDto setName(String name) {
        this.name = name;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public ClientRegisterDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public int getAge() {
        return age;
    }

    public ClientRegisterDto setAge(int age) {
        this.age = age;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public ClientRegisterDto setAddress(Address address) {
        this.address = address;
        return this;
    }
}

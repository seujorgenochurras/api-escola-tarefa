package io.github.seujorgenochurras.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class AddressDto {
    private String cep;

    private String addressNumber;

    @NotNull
    private String streetName;

    @NotNull
    private String neightboorhood;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @Column(name = "additional_info")
    private String additionalInfo;

    public String getStreetName() {
        return streetName;
    }

    public AddressDto setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getNeightboorhood() {
        return neightboorhood;
    }

    public AddressDto setNeightboorhood(String neightboorhood) {
        this.neightboorhood = neightboorhood;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public AddressDto setState(String state) {
        this.state = state;
        return this;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public AddressDto setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public AddressDto setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public AddressDto setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }
}

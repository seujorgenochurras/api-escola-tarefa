package io.github.seujorgenochurras.api.dto;

public class AddressDto {
    private String cep;

    private String description;

    private String addressNumber;

    public String getCep() {
        return cep;
    }

    public AddressDto setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddressDto setDescription(String description) {
        this.description = description;
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

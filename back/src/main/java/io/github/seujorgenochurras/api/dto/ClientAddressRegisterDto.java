package io.github.seujorgenochurras.api.dto;

import jakarta.validation.constraints.NotNull;

public class ClientAddressRegisterDto {

    @NotNull
    private AddressDto address;
    @NotNull
    private String clientToken;

    public AddressDto getAddress() {
        return address;
    }

    public ClientAddressRegisterDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public String getClientToken() {
        return clientToken;
    }

    public ClientAddressRegisterDto setClientToken(String clientToken) {
        this.clientToken = clientToken;
        return this;
    }
}

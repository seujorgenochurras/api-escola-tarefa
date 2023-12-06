package io.github.seujorgenochurras.api.dto;

import io.github.seujorgenochurras.domain.model.Address;
import io.github.seujorgenochurras.domain.model.Client;

public class ClientAddressDto {
    private Address address;
    private Client client;

    public Address getAddress() {
        return address;
    }

    public ClientAddressDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public ClientAddressDto setClient(Client client) {
        this.client = client;
        return this;
    }
}

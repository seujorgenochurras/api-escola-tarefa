package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.*;

@Entity
public class ClientAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "client_fk")
    private Client client;

    @OneToOne
    @JoinColumn(name = "address_fk")
    private Address address;

    public Integer getId() {
        return id;
    }

    public ClientAddress setId(Integer id) {
        this.id = id;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public ClientAddress setClient(Client client) {
        this.client = client;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public ClientAddress setAddress(Address address) {
        this.address = address;
        return this;
    }
}

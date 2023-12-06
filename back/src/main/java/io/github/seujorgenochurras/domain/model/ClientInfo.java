package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity()
public class ClientInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @OneToOne
    @JoinColumn(name = "client_token")
    private Client clientToken;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String cpf;

    @NotNull
    private String email;


    public int getId() {
        return id;
    }

    public ClientInfo setId(int id) {
        this.id = id;
        return this;
    }

    public Client getClientToken() {
        return clientToken;
    }

    public ClientInfo setClientToken(Client clientToken) {
        this.clientToken = clientToken;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClientInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ClientInfo setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public ClientInfo setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientInfo setEmail(String email) {
        this.email = email;
        return this;
    }
}

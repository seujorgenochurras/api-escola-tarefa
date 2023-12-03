package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Client {
    @Id
    private String token;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    private boolean isSeller;

    public boolean isSeller() {
        return isSeller;
    }

    public Client setIsSeller(boolean seller) {
        isSeller = seller;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Client setToken(String token) {
        this.token = token;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Client setUsername(String username) {
        this.username = username;
        return this;
    }

}

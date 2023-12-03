package io.github.seujorgenochurras.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientRegisterDto {
    @NotNull
    private String username;

    @NotNull
    @Size(max = 200)
    private String password;

    @NotNull
    private boolean isSeller = false;
    public boolean isSeller() {
        return isSeller;
    }

    public ClientRegisterDto setSeller(boolean seller) {
        isSeller = seller;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ClientRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ClientRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

}
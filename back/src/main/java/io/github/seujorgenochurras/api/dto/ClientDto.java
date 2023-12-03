package io.github.seujorgenochurras.api.dto;

public class ClientDto {
    private String token;
    private String userName;
    private boolean isSeller;

    public String getToken() {
        return token;
    }

    public ClientDto setToken(String token) {
        this.token = token;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ClientDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public ClientDto setSeller(boolean seller) {
        isSeller = seller;
        return this;
    }
}

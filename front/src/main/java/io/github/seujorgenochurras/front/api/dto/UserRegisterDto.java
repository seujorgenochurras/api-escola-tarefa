package io.github.seujorgenochurras.front.api.dto;

public class UserRegisterDto {

    private String username;
    private String password;

    private boolean seller;

    public boolean isSeller() {
        return seller;
    }

    public UserRegisterDto setIsSeller(boolean seller) {
        this.seller = seller;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }
}

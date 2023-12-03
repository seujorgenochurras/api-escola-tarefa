package io.github.seujorgenochurras.api.dto;

public class ClientLoginDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public ClientLoginDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ClientLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}

package io.github.seujorgenochurras.front.api.dto;

public class RegisterClientInfoDto {
    private String name;
    private String phoneNumber;
    private String email;
    private String cpf;

    private String clientToken;

    public String getClientToken() {
        return clientToken;
    }

    public RegisterClientInfoDto setClientToken(String clientToken) {
        this.clientToken = clientToken;
        return this;
    }

    public String getName() {
        return name;
    }

    public RegisterClientInfoDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RegisterClientInfoDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterClientInfoDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public RegisterClientInfoDto setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }
}

package io.github.seujorgenochurras.api.dto;

import jakarta.validation.constraints.NotNull;

public class RegisterInfoDto {

    @NotNull
    private String clientToken;

    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String cpf;

    @NotNull
    private String email;

    public String getClientToken() {
        return clientToken;
    }

    public RegisterInfoDto setClientToken(String clientToken) {
        this.clientToken = clientToken;
        return this;
    }

    public String getName() {
        return name;
    }

    public RegisterInfoDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RegisterInfoDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public RegisterInfoDto setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterInfoDto setEmail(String email) {
        this.email = email;
        return this;
    }
}

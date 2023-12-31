package io.github.seujorgenochurras.front.api.dto;

import com.google.gson.annotations.SerializedName;

public class PersonalInformation {

    @SerializedName("name")
    private String name;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("email")
    private String email;

    @SerializedName("cpf")
    private String CPF;



    public String getName() {
        return name;
    }

    public PersonalInformation setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PersonalInformation setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonalInformation setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCPF() {
        return CPF;
    }

    public PersonalInformation setCPF(String CPF) {
        this.CPF = CPF;
        return this;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}

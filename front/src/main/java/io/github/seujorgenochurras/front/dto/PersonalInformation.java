package io.github.seujorgenochurras.front.dto;

public class PersonalInformation {

    private String name;
    private String phoneNumber;
    private String email;
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
}

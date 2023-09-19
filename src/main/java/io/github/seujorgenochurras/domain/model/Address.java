package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

//todo add constructor that fills with only zipCode
@Embeddable
public class Address {

    public Address() {
    }

    @NotNull
    @Length(max = 20) //todo verify maximum length
    private String zipCode;

    @NotNull
    private String streetName;

    @NotNull
    private String addressNumber;

    @Column(name = "additional_info")
    private String additionalInfo;

    public Address(String zipCode, String streetName, String addressNumber, String additionalInfo) {
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.addressNumber = addressNumber;
        this.additionalInfo = additionalInfo;
    }

    public Address(String zipCode, String streetName, String addressNumber) {
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.addressNumber = addressNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Address setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Address setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public Address setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + zipCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}

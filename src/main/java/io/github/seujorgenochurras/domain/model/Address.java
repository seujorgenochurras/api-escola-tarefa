package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

//todo add constructor that fills with only zipCode
@Embeddable
public class Address {
    @NotNull
    @Length(max = 20) //todo verify maximum length
    private final String zipCode;

    @NotNull
    private final String streetName;

    @NotNull
    private final String addressNumber;

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
}

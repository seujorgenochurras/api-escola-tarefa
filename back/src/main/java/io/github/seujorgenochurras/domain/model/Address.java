package io.github.seujorgenochurras.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

//todo add constructor that fills with only zipCode
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Length(max = 20) //todo verify maximum length
    private String cepCode;

    @NotNull
    private String streetName;

    @NotNull
    private String addressNumber;

    @NotNull
    private String neightboorhood;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @Column(name = "additional_info")
    private String additionalInfo;

    public Integer getId() {
        return id;
    }

    public Address setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCepCode() {
        return cepCode;
    }

    public Address setCepCode(String cepCode) {
        this.cepCode = cepCode;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public Address setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public Address setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getNeightboorhood() {
        return neightboorhood;
    }

    public Address setNeightboorhood(String neightboorhood) {
        this.neightboorhood = neightboorhood;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Address setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }
}

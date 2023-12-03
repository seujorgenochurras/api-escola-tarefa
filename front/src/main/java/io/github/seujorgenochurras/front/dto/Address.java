package io.github.seujorgenochurras.front.dto;

public class Address {

    private String CEP;
    private String state;
    private String neighborhood;
    private String street;
    private String city;
    private String houseNumber;
    private String houseDescription;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getCEP() {
        return CEP;
    }

    public Address setCEP(String CEP) {
        this.CEP = CEP;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public Address setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Address setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public Address setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
        return this;
    }
}

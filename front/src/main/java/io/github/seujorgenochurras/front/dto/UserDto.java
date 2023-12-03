package io.github.seujorgenochurras.front.dto;

import com.google.gson.annotations.SerializedName;

public class UserDto {

    private Address address;

    private PersonalInformation personalInformation;

    @SerializedName("userName")
    private String userName;

    @SerializedName("id")
    private String token;

    @SerializedName("isSeller")
    private boolean isSeller;

    public Address getAddress() {
        return address;
    }

    public UserDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public boolean isSeller() {
        //TODO
        return true;
    }

    public UserDto setSeller(boolean seller) {
        isSeller = seller;
        return this;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public UserDto setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserDto setToken(String token) {
        this.token = token;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "address=" + address +
                ", personalInformation=" + personalInformation +
                ", userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                ", isSeller=" + isSeller +
                '}';
    }
}

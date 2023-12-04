package io.github.seujorgenochurras.front.api.dto;

import com.google.gson.annotations.SerializedName;

public class UserDto {

    private Address address;

    private PersonalInformation personalInformation;

    @SerializedName("username")
    private String userName;

    @SerializedName("token")
    private String token;

    @SerializedName("seller")
    private boolean isSeller;

    public Address getAddress() {
        return address;
    }

    public UserDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public boolean isSeller() {
        return isSeller;
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

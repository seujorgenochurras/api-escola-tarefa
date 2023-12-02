package io.github.seujorgenochurras.front.dto;

public class UserDto {
    private Address address;
    private PersonalInformation personalInformation;

    private String userName;

    //I know it should be hashed, but I don't have time to do SHA256 rn
    private String password;

    public Address getAddress() {
        return address;
    }

    public UserDto setAddress(Address address) {
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }
}

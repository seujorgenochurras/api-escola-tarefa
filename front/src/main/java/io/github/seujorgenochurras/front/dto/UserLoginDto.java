package io.github.seujorgenochurras.front.dto;

public class UserLoginDto {
    private String userName;
    private String userPass;

    public String getUserName() {
        return userName;
    }

    public UserLoginDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPass() {
        return userPass;
    }

    public UserLoginDto setUserPass(String userPass) {
        this.userPass = userPass;
        return this;
    }

    public UserLoginDto(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }
}

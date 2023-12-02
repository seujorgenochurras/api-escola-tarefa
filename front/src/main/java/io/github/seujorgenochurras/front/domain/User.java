package io.github.seujorgenochurras.front.domain;

import io.github.seujorgenochurras.front.dto.UserDto;

public class User {
    private static UserDto currentUser = new UserDto();

    public static UserDto getCurrentUser() {
        return currentUser;
    }
    public static UserDto login(UserDto userDto){
        currentUser = userDto;
        return currentUser;
    }
    public static void logout(){
        currentUser = new UserDto();
    }

    public static boolean isLoggedIn(){
        return currentUser.getPassword() != null;
    }

    public static void setCurrentUser(UserDto currentUser) {
        User.currentUser = currentUser;
    }
}


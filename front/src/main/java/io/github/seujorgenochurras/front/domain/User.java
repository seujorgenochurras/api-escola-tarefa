package io.github.seujorgenochurras.front.domain;

import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
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
        Main.getStageManager().switchScene(Scenes.LOGIN);
    }

    public static boolean isLoggedIn(){
       return true;
        // return currentUser.getPassword() != null && validateCurrentUser();
    }

    public static boolean validateCurrentUser(){
        return true;
    }

    public static void setCurrentUser(UserDto currentUser) {
        User.currentUser = currentUser;
    }
}


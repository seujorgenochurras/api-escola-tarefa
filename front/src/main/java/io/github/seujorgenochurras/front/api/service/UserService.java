package io.github.seujorgenochurras.front.api.service;

import com.google.gson.Gson;
import io.github.seujorgenochurras.front.api.ApiRequest;
import io.github.seujorgenochurras.front.api.DefaultMappings;
import io.github.seujorgenochurras.front.api.dto.*;
import io.github.seujorgenochurras.front.domain.User;
import io.github.seujorgenochurras.front.api.request.Response;
import io.github.seujorgenochurras.front.util.PopupUtil;

public class UserService {
    /**
     *
     * @return true if successfully registered user
     */
    public boolean registerAndSaveUser(UserRegisterDto userRegisterDto){

        Response response = ApiRequest.postRequest(DefaultMappings.REGISTER_CLIENT)
                .body(gson.toJson(userRegisterDto)).request();

        if(response.getStatusCode() != 201) {
            PopupUtil.showErrorMessage(response.getBody(), "Ok");
            return false;
        }

        UserDto userDto = gson.fromJson(response.getBody(), UserDto.class);
        User.setUser(userDto);
        return true;
    }

    public boolean registerAndSaveUserInfo(RegisterClientInfoDto userPersonalInfoDto){
        Response response = ApiRequest.postRequest(DefaultMappings.REGISTER_PERSONAL_INFO)
                .body(gson.toJson(userPersonalInfoDto)).request();

        if(response.getStatusCode() != 201) {
            PopupUtil.showErrorMessage(response.getBody(), "Ok");
            return false;
        }

        User.getCurrentUser().setPersonalInformation(gson.fromJson(response.getBody(), PersonalInformation.class));
        return true;
    }



    public boolean registerAndSaveUserAddress(){
        return false;
    }

    private static final Gson gson = new Gson();
    public boolean loginAndSaveUser(UserLoginDto userLoginDto){
        Response response = ApiRequest.postRequest(DefaultMappings.LOGIN_CLIENT)
                .body(gson.toJson(userLoginDto)).request();

        if(response.getStatusCode() != 200) {
            PopupUtil.showErrorMessage(response.getBody(), "Ok");
            return false;
        }

        String userToken = response.getBody();
        User.setUser(getUserAccountInfo(userToken));
        return true;
    }

    public UserDto getUserAccountInfo(String userToken){
        Response response = ApiRequest.postRequest("client/account").body(userToken).request();
        if(response.getStatusCode() != 200){
            PopupUtil.showErrorMessage(response.getBody());
            return null;
        }
        return gson.fromJson(response.getBody(), UserDto.class);
    }




}

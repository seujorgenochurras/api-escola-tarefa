package io.github.seujorgenochurras.front.service;

import com.google.gson.Gson;
import io.github.seujorgenochurras.front.api.ApiRequest;
import io.github.seujorgenochurras.front.api.DefaultMappings;
import io.github.seujorgenochurras.front.domain.User;
import io.github.seujorgenochurras.front.dto.UserDto;
import io.github.seujorgenochurras.front.dto.UserLoginDto;
import io.github.seujorgenochurras.front.request.Response;
import io.github.seujorgenochurras.front.util.PopupUtil;

public class UserService {
    /***
     *
     * @return true if successfully registered user
     */
    public boolean registerUser(UserDto userDto){

        //TODO
        return false;
    }

    private static final Gson gson = new Gson();
    public boolean loginUser(UserLoginDto userLoginDto){
        Response response = ApiRequest.postRequest(DefaultMappings.LOGIN_CLIENT)
                .body(gson.toJson(userLoginDto)).request();
        if(response.getStatusCode() != 201) {
            PopupUtil.showErrorMessage(response.getBody());
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

package io.github.seujorgenochurras.front.service;

import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
import io.github.seujorgenochurras.front.config.StageManager;
import io.github.seujorgenochurras.front.domain.User;

/***
 * Special service for changing between views that needs auth
 */
public class ViewService {

    public boolean gotoProductPage(){
        //if(!User.isLoggedIn()) return false;

        Main.getStageManager().switchScene(Scenes.PRODUCT_PAGE);
        return true;
    }

}

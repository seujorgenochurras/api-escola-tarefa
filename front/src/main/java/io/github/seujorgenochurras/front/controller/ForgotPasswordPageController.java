package io.github.seujorgenochurras.front.controller;

import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ForgotPasswordPageController {

    @FXML
    private Button registerButton;

    @FXML
    public void onRegisterButtonClick(){
        Main.getStageManager().switchScene(Scenes.REGISTER);
    }

}

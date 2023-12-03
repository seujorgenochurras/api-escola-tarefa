package io.github.seujorgenochurras.front.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RegisterController {
    @FXML
    private Label closeButton;

    @FXML
    private JFXPasswordField passField;

    @FXML
    private JFXPasswordField confirmPassField;

    @FXML
    private JFXTextField emailField;

    @FXML
    private JFXTextField userField;

    @FXML
    private JFXCheckBox isSellerCheckbox;



    @FXML
    private void onCloseButtonClick(){
        Main.getStageManager().switchScene(Scenes.LOGIN);
    }

    @FXML
    private void onRegisterButtonClick(){
        Main.getStageManager().switchScene(Scenes.REGISTER_INFO);
    }

}

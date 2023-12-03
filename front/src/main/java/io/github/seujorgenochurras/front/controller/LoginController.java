package io.github.seujorgenochurras.front.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button loginButton;

    @FXML
    private Label registerButton;

    @FXML
    private Label forgotPassButton;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField userField;

    @FXML
    public void onRegisterButtonClick(){
        Main.getStageManager().switchScene(Scenes.REGISTER);
    }

    @FXML
    public void onForgotPasswordClick(){
        Main.getStageManager().switchScene(Scenes.FORGOT_PASSWORD);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}

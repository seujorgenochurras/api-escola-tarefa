package io.github.seujorgenochurras.front.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
import io.github.seujorgenochurras.front.domain.User;
import io.github.seujorgenochurras.front.dto.UserLoginDto;
import io.github.seujorgenochurras.front.service.UserService;
import io.github.seujorgenochurras.front.util.PopupUtil;
import io.github.seujorgenochurras.front.util.ValidatorBoolean;
import io.github.seujorgenochurras.front.validator.DefaultValidators;
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

    private static final UserService userService = new UserService();

    @FXML
    public void onRegisterButtonClick() {
        Main.getStageManager().switchScene(Scenes.REGISTER);
    }

    @FXML
    public void onForgotPasswordClick() {
        Main.getStageManager().switchScene(Scenes.FORGOT_PASSWORD);
    }

    @FXML
    public void onLoginButtonAction() {
        if (!validateFields()) {
            PopupUtil.showAlertMessage("Campos inválidos foram encontrados!");
            return;
        }
        boolean wasSuccessfulLogin = userService.loginAndSaveUser(parseFields());
        if (!wasSuccessfulLogin) {
            return;
        }
        User.gotoProductsPage();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addValidators();
    }

    private UserLoginDto parseFields() {
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setPassword(passwordField.getText());
        userLoginDto.setUsername(userField.getText());
        return userLoginDto;
    }

    private boolean validateFields() {
        ValidatorBoolean validatorBoolean = new ValidatorBoolean();
        validatorBoolean.setValid(passwordField.validate()).setValid(userField.validate());

        return validatorBoolean.isValid();
    }

    private void addValidators() {
        userField.getValidators().add(DefaultValidators.generateNotBlankValidator());
        passwordField.getValidators().add(DefaultValidators.generateNotBlankValidator());

    }

}

package io.github.seujorgenochurras.front.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
import io.github.seujorgenochurras.front.dto.UserRegisterDto;
import io.github.seujorgenochurras.front.service.UserService;
import io.github.seujorgenochurras.front.util.PopupUtil;
import io.github.seujorgenochurras.front.util.ValidatorBoolean;
import io.github.seujorgenochurras.front.validator.DefaultValidators;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private Label closeButton;

    @FXML
    private JFXPasswordField passField;

    @FXML
    private JFXPasswordField confirmPassField;

    @FXML
    private JFXTextField userField;

    @FXML
    private JFXCheckBox isSellerCheckbox;

    private static final UserService userService = new UserService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addValidators();
    }

    private boolean validateFields() {
        ValidatorBoolean validatorBoolean = new ValidatorBoolean();

        validatorBoolean.setValid(passField.validate())
                .setValid(userField.validate())
                .setValid(confirmPassField.validate());

        return validatorBoolean.isValid();
    }

    private void addValidators() {
        userField.getValidators().add(DefaultValidators.generateNotBlankValidator());
        passField.getValidators().add(DefaultValidators.generateNotBlankValidator());
        confirmPassField.getValidators().add(DefaultValidators.generateStringToBeEqualsValidator(passField));

    }

    @FXML
    private void onCloseButtonClick() {
        Main.getStageManager().switchScene(Scenes.LOGIN);
    }

    @FXML
    private void onRegisterButtonClick() {
        if (!validateFields()) {
            PopupUtil.showAlertMessage("Alguns campos estão inválidos");
            return;
        }
        boolean successfullyRegistered = userService.registerAndSaveUser(parseFields());
        if(!successfullyRegistered){
            return;
        }
        Main.getStageManager().switchScene(Scenes.REGISTER_INFO);
    }

    private UserRegisterDto parseFields() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto
                .setPassword(passField.getText())
                .setUsername(userField.getText())
                .setIsSeller(isSellerCheckbox.isSelected());

        return userRegisterDto;
    }

}

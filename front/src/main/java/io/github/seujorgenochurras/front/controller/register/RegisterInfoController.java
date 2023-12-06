package io.github.seujorgenochurras.front.controller.register;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.api.dto.RegisterClientInfoDto;
import io.github.seujorgenochurras.front.config.Scenes;
import io.github.seujorgenochurras.front.api.service.UserService;
import io.github.seujorgenochurras.front.domain.User;
import io.github.seujorgenochurras.front.util.PopupUtil;
import io.github.seujorgenochurras.front.util.ValidatorBoolean;

import static io.github.seujorgenochurras.front.validator.DefaultFieldValidators.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterInfoController implements Initializable {

    private static final UserService userService = new UserService();

    @FXML
    private Label closeButton;

    @FXML
    private JFXTextField cpfField;

    @FXML
    private JFXTextField emailField;

    @FXML
    private JFXTextField nameField;

    @FXML
    private JFXTextField phoneNumberField;

    @FXML
    private Button registerButton;

    @FXML
    private Label registerLaterButton;


    public RegisterInfoController() {
    }


    private void addValidators() {
        nameField.getValidators().add(generateNotBlankValidator());
        phoneNumberField.getValidators().add(generateNotBlankValidator());
        cpfField.getValidators().add(generateNotBlankValidator());
        cpfField.getValidators().add(generateCpfValidator());


        emailField.getValidators().add(generateEmailValidator());
        emailField.getValidators().add(generateNotBlankValidator());
    }

    @FXML
    private void onRegisterLater() {
        JFXAlert alert = new JFXAlert(Main.getStageManager().getStage());
        alert.initModality(Modality.APPLICATION_MODAL);
        JFXDialogLayout layout = new JFXDialogLayout();


        layout.setHeading(new Label("Atenção"));
        layout.setBody(new Label("Você tem certeza que não quer preencher agora?"));
        JFXButton acceptButton = new JFXButton("Preencher agora");
        JFXButton denialButton = new JFXButton("Preencher depois");

        denialButton.setOnAction(event -> {
            User.gotoProductsPage();
            alert.hideWithAnimation();
        });

        acceptButton.setOnAction(event -> alert.hideWithAnimation());
        layout.setActions(denialButton, acceptButton);
        alert.setContent(layout);
        alert.show();
    }

    @FXML
    private void onCloseButtonClick() {
        onRegisterLater();
    }

    @FXML
    private void onRegisterButtonClick() {
        if (!validateFields()) {
            PopupUtil.showAlertMessage("Alguns campos estão inválidos");
            return;
        }
        boolean successfullyRegistered = userService.registerAndSaveUserInfo(parseFields());
        if (!successfullyRegistered) {
            return;
        }
        User.gotoProductsPage();

    }

    private RegisterClientInfoDto parseFields() {
        RegisterClientInfoDto clientInfoDto = new RegisterClientInfoDto();
        return clientInfoDto
                .setClientToken(User.getCurrentUser().getToken())
                .setCpf(cpfField.getText()) // 590.230.770-83
                .setEmail(emailField.getText())
                .setPhoneNumber(phoneNumberField.getText())
                .setName(nameField.getText());
    }

    private boolean validateFields() {
        ValidatorBoolean validatorBoolean = new ValidatorBoolean();

        validatorBoolean.setValid(nameField.validate())
                .setValid(phoneNumberField.validate())
                .setValid(emailField.validate())
                .setValid(cpfField.validate());

        return validatorBoolean.isValid();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addValidators();
    }
}

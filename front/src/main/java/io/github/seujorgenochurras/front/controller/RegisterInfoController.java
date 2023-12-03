package io.github.seujorgenochurras.front.controller;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
import io.github.seujorgenochurras.front.dto.UserDto;
import io.github.seujorgenochurras.front.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;

public class RegisterInfoController {

    private static final UserService userService = new UserService();
    @FXML
    private Label closeButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label registerLaterButton;


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
            onRegisterButtonClick();
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
        //validateFields();
        //boolean successfulRegistration = userService.registerAndSaveUser(parseFormData());
        // viewService.gotoProductPage();
        Main.getStageManager().switchScene(Scenes.PRODUCT_PAGE);


    }

    private UserDto parseFormData() {
        return new UserDto();
    }

    private void validateFields() {
        //todo
    }
}

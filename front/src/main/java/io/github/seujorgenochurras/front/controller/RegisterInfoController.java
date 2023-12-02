package io.github.seujorgenochurras.front.controller;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
import javafx.css.StyleClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;

public class RegisterInfoController {
    @FXML
    private Label closeButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label registerLaterButton;


    @FXML
    private void onRegisterLater(){
        JFXAlert alert = new JFXAlert(Main.getStageManager().getStage());
        alert.initModality(Modality.APPLICATION_MODAL);
        JFXDialogLayout layout = new JFXDialogLayout();

        layout.setHeading(new Label("Atenção"));
        layout.setBody(new Label("Você tem certeza que não quer preencher isso agora?"));
        JFXButton acceptButton = new JFXButton("Sim");
        JFXButton denialButton = new JFXButton("Não");


        denialButton.setOnAction(event -> alert.hideWithAnimation());
        layout.setActions(acceptButton);
        alert.setContent(layout);
        alert.show();
    }

    @FXML
    private void onCloseButtonClick(){
        Main.getStageManager().switchScene(Scenes.LOGIN);
    }

    @FXML
    private void onRegisterButtonClick(){
        Main.getStageManager().switchScene(Scenes.REGISTER_INFO);
    }

    @FXML
    private void finishRegistration(){

    }
}

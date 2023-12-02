package io.github.seujorgenochurras.front.util;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.config.Scenes;
import io.github.seujorgenochurras.front.domain.User;
import javafx.scene.control.Label;
import javafx.stage.Modality;

public class ErrorUtil {

    public static void showErrorMessage(String errorMessage) {
        JFXAlert alert = new JFXAlert(Main.getStageManager().getStage());
        alert.initModality(Modality.APPLICATION_MODAL);
        JFXDialogLayout layout = new JFXDialogLayout();


        layout.setHeading(new Label("Oh não!!"));
        layout.setBody(new Label(errorMessage));
        JFXButton acceptButton = new JFXButton("Voltar ao login");

        acceptButton.setOnAction(event -> {
           User.logout();
           Main.getStageManager().switchScene(Scenes.LOGIN);
        });
        layout.setActions(acceptButton);
        alert.setContent(layout);
        alert.show();
    }
}

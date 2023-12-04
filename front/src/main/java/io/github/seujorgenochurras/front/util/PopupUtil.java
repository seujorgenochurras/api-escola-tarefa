package io.github.seujorgenochurras.front.util;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import io.github.seujorgenochurras.front.Main;
import javafx.scene.control.Label;
import javafx.stage.Modality;

public class PopupUtil {

    public static void showErrorMessage(String errorMessage, String okButtonText) {
        JFXAlert alert = new JFXAlert(Main.getStageManager().getStage());
        alert.initModality(Modality.APPLICATION_MODAL);
        JFXDialogLayout layout = new JFXDialogLayout();


        layout.setHeading(new Label("Oh não!!"));
        layout.setBody(new Label(errorMessage));
        JFXButton acceptButton = new JFXButton(okButtonText);

        acceptButton.setOnAction(event -> alert.hideWithAnimation());

        layout.setActions(acceptButton);
        alert.setContent(layout);
        alert.show();
    }

    public static void showErrorMessage(String errorMessage) {
        showErrorMessage(errorMessage, "Voltar ao login");
    }

    public static void showAlertMessage(String alertMessage) {
        JFXAlert alert = new JFXAlert(Main.getStageManager().getStage());
        alert.initModality(Modality.APPLICATION_MODAL);
        JFXDialogLayout layout = new JFXDialogLayout();


        layout.setHeading(new Label("Cuidado"));
        layout.setBody(new Label(alertMessage));
        JFXButton acceptButton = new JFXButton("Ok");

        acceptButton.setOnAction(event -> alert.hideWithAnimation());
        layout.setActions(acceptButton);
        alert.setContent(layout);
        alert.show();
    }
}

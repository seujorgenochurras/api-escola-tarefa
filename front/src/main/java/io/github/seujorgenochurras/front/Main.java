package io.github.seujorgenochurras.front;

import io.github.seujorgenochurras.front.config.StageManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static StageManager stageManager;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-page.fxml"));
        stageManager = new StageManager(stage);
        Scene scene = new Scene(fxmlLoader.load());
        stageManager.switchScene(scene);
        PopupUtil.showAlert("vai volbtroajkpsd");
    }
    public static void main(String[] args) {
        launch();

    }

    public static StageManager getStageManager(){
        return stageManager;
    }
}
package io.github.seujorgenochurras.front.config;

import com.jfoenix.controls.JFXAlert;
import io.github.seujorgenochurras.front.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageManager {
    private final Stage stage;

    private Scene previousScene;
    private Scene currentScene;

    public StageManager(Stage primaryStage) {
        this.stage = primaryStage;
    }
    /**
        {@return Current scene}
     */
    public Scene switchScene(Scene scene){
        setPreviousScene(stage.getScene());
        stage.setScene(scene);
        stage.show();
        setCurrentScene(scene);
        return getCurrentScene();
    }

    public Scene switchScene(Scenes scenes){
        return switchScene(scenes.sceneSource);
    }
    public Scene switchScene(String sceneSource){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(sceneSource));
        Scene newScene = null;
        try {
            newScene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            JFXAlert<Object> alert = new JFXAlert<>(stage);
            alert.setContentText("Não foi possível carregar a página");
            alert.show();
        }
        return switchScene(newScene);
    }
    public Scene goToPreviousScene(){
        return switchScene(previousScene);
    }

    private Scene getPreviousScene() {
        return previousScene;
    }

    private StageManager setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
        return this;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    private StageManager setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
        return this;
    }

    public Stage getStage() {
        return stage;
    }
}

package io.github.seujorgenochurras.front.util;

import io.github.seujorgenochurras.front.Main;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class FXMLLoaderUtils {

    public static FXMLLoader createFXMLLoader(String fxmlPath){
        return new FXMLLoader(Main.class.getResource(fxmlPath));
    }
    public static <T> T loadFXML(FXMLLoader fxmlLoader){
         try {
            return fxmlLoader.load();
        } catch (IOException e) {
            PopupUtil.showErrorMessage("Algo muito errado aconteceu\n" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

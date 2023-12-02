package io.github.seujorgenochurras.front.controller;

import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.controller.test.ProductsTest;
import io.github.seujorgenochurras.front.domain.User;
import io.github.seujorgenochurras.front.dto.ProductDto;
import io.github.seujorgenochurras.front.util.ErrorUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductPageController implements Initializable {

    @FXML
    private Label closeButton;

    @FXML
    private GridPane productGrid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            init();
    }

    public void init() {
        int gridColumn = 1;
        int gridRow = 0;
        for (ProductDto productDto : ProductsTest.products) {

            if (gridColumn % 3 == 0) {
                gridRow++;
                gridColumn = 1;
            }
            FXMLLoader productPaneLoader = new FXMLLoader(Main.class.getResource("product-pane.fxml"));
            AnchorPane productPane = getProductPane(productPaneLoader);
            ProductPaneController productPaneController = productPaneLoader.getController();
            productPaneController.setProduct(productDto);

            productGrid.add(productPane, gridColumn, gridRow);

            gridColumn++;
        }
    }

    private AnchorPane getProductPane(FXMLLoader fxmlLoader) {

        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            ErrorUtil.showErrorMessage("Algo muito errado aconteceu\n" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void onCloseButton(){
        User.logout();
    }
}

package io.github.seujorgenochurras.front.controller.product;

import io.github.seujorgenochurras.front.domain.User;
import io.github.seujorgenochurras.front.api.dto.ProductDto;
import io.github.seujorgenochurras.front.api.service.ProductService;
import io.github.seujorgenochurras.front.util.FXMLLoaderUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    @FXML
    private Button cartButton;

    @FXML
    private Label closeButton;

    @FXML
    private Pane manageProductsPane;

    @FXML
    private Button orderButton;

    @FXML
    private GridPane productGrid;


    private static final ProductService productService = new ProductService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initUserSpecificGUI();
        initProductsGrid();
    }

    @FXML
    private void onOrderButtonClick(){

    }

    @FXML
    private void onCartButtonClick(){

    }

    public void initProductsGrid() {
        int gridColumn = 1;
        int gridRow = 0;
        for (ProductDto productDto : productService.getProducts()) {

            if (gridColumn % 3 == 0) {
                gridRow++;
                gridColumn = 1;
            }
            FXMLLoader productPaneLoader = FXMLLoaderUtils.createFXMLLoader("product-pane.fxml");
            AnchorPane productPane = FXMLLoaderUtils.loadFXML(productPaneLoader);

            ProductPaneController productPaneController = productPaneLoader.getController();
            productPaneController.setProduct(productDto);

            productGrid.add(productPane, gridColumn, gridRow);

            gridColumn++;
        }
    }

    public void onCloseButton() {
        User.logout();
    }

    private void initUserSpecificGUI() {

        if (User.getCurrentUser().isSeller()) {
            FXMLLoader manageProductsFXMLLoader = FXMLLoaderUtils.createFXMLLoader("adm-products-button.fxml");
            Pane manageProductsButtonPane = FXMLLoaderUtils.loadFXML(manageProductsFXMLLoader);
            manageProductsPane.getChildren().add(manageProductsButtonPane);
        }
    }
}

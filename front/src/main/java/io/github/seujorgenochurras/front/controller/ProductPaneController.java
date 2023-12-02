package io.github.seujorgenochurras.front.controller;

import io.github.seujorgenochurras.front.dto.ProductDto;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductPaneController implements Initializable {

        @FXML
        private Button buyButton;

        @FXML
        private ImageView imageView;

        @FXML
        private Label productNameLabel;

        @FXML
        private Label productPriceLabel;

        @FXML
        private Spinner<Integer> quantitySpinner;

        public ProductPaneController setProduct(ProductDto productDto){
                productNameLabel.setText(productDto.getName());
                productPriceLabel.setText("R$" + productDto.getPrice().toString());
                return this;
        }
        public Button getBuyButton() {
                return buyButton;
        }

        public ProductPaneController setBuyButton(Button buyButton) {
                this.buyButton = buyButton;
                return this;
        }

        public ImageView getImageView() {
                return imageView;
        }

        public ProductPaneController setImageView(ImageView imageView) {
                this.imageView = imageView;
                return this;
        }

        public Label getProductNameLabel() {
                return productNameLabel;
        }

        public ProductPaneController setProductNameLabel(Label productNameLabel) {
                this.productNameLabel = productNameLabel;
                return this;
        }

        public Label getProductPriceLabel() {
                return productPriceLabel;
        }

        public ProductPaneController setProductPriceLabel(Label productPriceLabel) {
                this.productPriceLabel = productPriceLabel;
                return this;
        }

        public Spinner<Integer> getQuantitySpinner() {
                return quantitySpinner;
        }

        public ProductPaneController setQuantitySpinner(Spinner<Integer> quantitySpinner) {
                this.quantitySpinner = quantitySpinner;
                return this;
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }
}

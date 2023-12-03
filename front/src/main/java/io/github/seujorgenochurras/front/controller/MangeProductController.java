package io.github.seujorgenochurras.front.controller;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.github.seujorgenochurras.front.domain.Product;
import io.github.seujorgenochurras.front.domain.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class MangeProductController implements Initializable {

    @FXML
    private Label closePageButton;

    @FXML
    private TreeTableColumn<Product, String> productCategoryColumn;

    @FXML
    private TreeTableColumn<Product, Number> productIdColumn;

    @FXML
    private TreeTableColumn<Product, String> productNameColumn;

    @FXML
    private TreeTableColumn<Product, Number> productPriceColumn;

    @FXML
    private TreeTableColumn<Product, Number> productSoldAmount;

    @FXML
    private JFXTreeTableView<Product> productsView;

    @FXML
    private Button registerProductButton;

    @FXML
    private Button removeProductButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        addAllProducts();
    }

    public void initColumns() {
        productNameColumn.setCellValueFactory((param) ->
                param.getValue().getValue().nameProperty()
        );
        productCategoryColumn.setCellValueFactory((param -> param.getValue().getValue().categoryProperty()));
        productIdColumn.setCellValueFactory((param -> param.getValue().getValue().idProperty()));
        productPriceColumn.setCellValueFactory((param -> param.getValue().getValue().priceProperty()));
        productSoldAmount.setCellValueFactory((param -> param.getValue().getValue().soldAmountProperty()));

    }

    public void addAllProducts() {
        ObservableList<Product> products = User.getSellerService().getSellerProductsAsObservable();
        TreeItem<Product> productTreeItems = new RecursiveTreeItem<>(products, RecursiveTreeObject::getChildren);
        productsView.setRoot(productTreeItems);
        productsView.setShowRoot(false);
    }
}

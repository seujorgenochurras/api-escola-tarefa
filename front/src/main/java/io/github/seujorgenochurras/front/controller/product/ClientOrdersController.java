package io.github.seujorgenochurras.front.controller.product;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.github.seujorgenochurras.front.Main;
import io.github.seujorgenochurras.front.api.dto.ProductOrderDto;
import io.github.seujorgenochurras.front.api.service.UserService;
import io.github.seujorgenochurras.front.config.Scenes;
import io.github.seujorgenochurras.front.domain.ClientOrder;
import io.github.seujorgenochurras.front.domain.Product;
import io.github.seujorgenochurras.front.domain.User;

import java.lang.String;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientOrdersController implements Initializable {

    @FXML
    private TreeTableColumn<ProductOrderDto, String> addressColumn;

    @FXML
    private TreeTableColumn<ProductOrderDto, String> clientNameColumn;

    @FXML
    private Label closePageButton;

    @FXML
    private TreeTableColumn<ProductOrderDto, Number> finalPriceColumn;

    @FXML
    private TreeTableColumn<ProductOrderDto, String> orderStatus;

    @FXML
    private TreeTableColumn<ProductOrderDto, Number> productCountColumn;

    @FXML
    private TreeTableColumn<ProductOrderDto, String> productNameColumn;

    @FXML
    private TreeTableColumn<ProductOrderDto, Number> productPriceColumn;

    @FXML
    private JFXTreeTableView<ProductOrderDto> productsView;

    @FXML
    private TreeTableColumn<ProductOrderDto, String> sellerNameColumn;

    private static final UserService userService = new UserService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        addAllProducts();
    }

    public void initColumns() {
        productNameColumn.setCellValueFactory((param) -> param.getValue().getValue().productNameProperty());

        productCountColumn.setCellValueFactory((param -> param.getValue().getValue().countProperty()));

        productPriceColumn.setCellValueFactory((param -> param.getValue().getValue().unitaryPriceProperty()));

        finalPriceColumn.setCellValueFactory((param -> param.getValue().getValue().totalPriceProperty()));

        addressColumn.setCellValueFactory((param -> param.getValue().getValue().addressProperty()));

        clientNameColumn.setCellValueFactory((param -> param.getValue().getValue().clientNameProperty()));

        orderStatus.setCellValueFactory((param -> param.getValue().getValue().orderStatusProperty()));

        sellerNameColumn.setCellValueFactory((param -> param.getValue().getValue().sellerNameProperty()));

    }

    public void addAllProducts() {
        ObservableList<ClientOrder> orders = userService.getUserOrders();
        TreeItem<Product> productTreeItems = new RecursiveTreeItem<>(products, RecursiveTreeObject::getChildren);
        productsView.setRoot(productTreeItems);
        productsView.setShowRoot(false);
    }

    @FXML
    private void closePageButton() {
        Main.getStageManager().switchScene(Scenes.PRODUCT_PAGE);
    }
}

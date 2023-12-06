package io.github.seujorgenochurras.front.api.dto;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductOrderDto extends RecursiveTreeObject<ProductOrderDto> {

    private SimpleStringProperty productName;
    private SimpleStringProperty orderStatus;
    private SimpleStringProperty sellerName;
    private SimpleStringProperty clientName;
    private SimpleStringProperty address;
    private SimpleDoubleProperty totalPrice;
    private SimpleDoubleProperty unitaryPrice;
    private SimpleIntegerProperty count;

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public String getOrderStatus() {
        return orderStatus.get();
    }

    public SimpleStringProperty orderStatusProperty() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus.set(orderStatus);
    }

    public String getSellerName() {
        return sellerName.get();
    }

    public SimpleStringProperty sellerNameProperty() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName.set(sellerName);
    }

    public String getClientName() {
        return clientName.get();
    }

    public SimpleStringProperty clientNameProperty() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName.set(clientName);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public double getTotalPrice() {
        return totalPrice.get();
    }

    public SimpleDoubleProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public double getUnitaryPrice() {
        return unitaryPrice.get();
    }

    public SimpleDoubleProperty unitaryPriceProperty() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(double unitaryPrice) {
        this.unitaryPrice.set(unitaryPrice);
    }

    public int getCount() {
        return count.get();
    }

    public SimpleIntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }
}

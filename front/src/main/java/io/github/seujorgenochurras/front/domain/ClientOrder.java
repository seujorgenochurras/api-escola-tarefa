package io.github.seujorgenochurras.front.domain;

import java.lang.Double;
import java.lang.String;

public class ClientOrder {

    private String productName;
    private String orderStatus;
    private String sellerName;
    private String clientName;
    private String address;
    private Double totalPrice;
    private Double unitaryPrice;
    private Integer count;

    public String getProductName() {
        return productName;
    }

    public ClientOrder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public ClientOrder setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getSellerName() {
        return sellerName;
    }

    public ClientOrder setSellerName(String sellerName) {
        this.sellerName = sellerName;
        return this;
    }

    public String getClientName() {
        return clientName;
    }

    public ClientOrder setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ClientOrder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public ClientOrder setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Double getUnitaryPrice() {
        return unitaryPrice;
    }

    public ClientOrder setUnitaryPrice(Double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public ClientOrder setCount(Integer count) {
        this.count = count;
        return this;
    }
}

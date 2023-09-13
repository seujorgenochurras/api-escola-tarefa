package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
public class ProductOrder {

    @NotNull
    @Id
    private String id;

    @NotNull
    @OneToOne
    @PrimaryKeyJoinColumn(name = "client_fk")
    private Client client;
    @NotNull
    @PrimaryKeyJoinColumn(name = "seller_fk")
    @OneToOne
    private Seller seller;

    @NotNull
    @Column(name = "total_price")
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "order_status")
    private OrderStatus orderStatus;


    @NotNull
    @Column(name = "amount")
    private int amount;

    public String getId() {
        return id;
    }

    public ProductOrder setId(String id) {
        this.id = id;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public ProductOrder setClient(Client client) {
        this.client = client;
        return this;
    }

    public Seller getSeller() {
        return seller;
    }

    public ProductOrder setSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ProductOrder setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ProductOrder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public ProductOrder setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }
}

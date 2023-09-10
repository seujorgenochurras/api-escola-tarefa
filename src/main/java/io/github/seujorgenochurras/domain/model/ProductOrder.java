package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProductOrder {

    @NotNull
    @Id
    private String id;

    @NotNull
    @OneToMany
    @Column(name = "client_fk")
    private Client client;
    @NotNull
    @Column(name = "seller_fk")
    @OneToMany
    private Seller seller;

    @NotNull
    private double totalPrice;


    @NotNull
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
}

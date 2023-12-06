package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    @OneToOne
    @PrimaryKeyJoinColumn(name = "client_fk")
    private Client client;
    @NotNull
    @PrimaryKeyJoinColumn(name = "seller_fk")
    @OneToOne
    private Client seller;

    @NotNull
    @PrimaryKeyJoinColumn(name = "product_fk")
    @OneToOne
    private Product product;

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

    @OneToOne
    @NotNull
    @JoinColumn(name = "address_fk")
    private Address address;

    public Product getProduct() {
        return product;
    }

    public ProductOrder setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public ProductOrder setAddress(Address address) {
        this.address = address;
        return this;
    }

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

    public Client getSeller() {
        return seller;
    }

    public ProductOrder setSeller(Client seller) {
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

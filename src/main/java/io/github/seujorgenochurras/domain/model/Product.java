package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(name = "name", length = 200)
    private String name;

    @OneToMany
    @Column(name = "seller_fk", length = 36)
    @NotNull
    private Seller seller;

    @NotNull
    @Column(name = "price", precision = 2)
    private double price;

    @NotNull
    @Column(name = "country", length = 30)
    private String country;

    @NotNull
    @Column(name = "quantity", precision = 3)
    private double quantity;
    @NotNull
    @Column(name = "quantified_as", length = 3)
    private String quantifiedAs;


    public String getId() {
        return id;
    }

    public Product setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Seller getSeller() {
        return seller;
    }

    public Product setSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Product setCountry(String country) {
        this.country = country;
        return this;
    }

    public double getQuantity() {
        return quantity;
    }

    public Product setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getQuantifiedAs() {
        return quantifiedAs;
    }

    public Product setQuantifiedAs(String quantifiedAs) {
        this.quantifiedAs = quantifiedAs;
        return this;
    }
}

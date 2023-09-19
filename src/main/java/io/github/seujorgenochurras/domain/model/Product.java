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

    @NotNull
    @Column(name = "description")
    private String description;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_fk")
    private Seller seller;

    @Column(name = "on_sale")
    @NotNull
    private boolean onSale = false;


    @NotNull
    @Column(name = "price", precision = 2)
    private double price;

    @NotNull
    @Column(name = "country", length = 30)
    private String country;

    @NotNull
    @Column(name = "quantity", precision = 3)
    private double minimalQuantity;

    @NotNull
    @Column(name = "stock")
    private int stock;

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

    public double getMinimalQuantity() {
        return minimalQuantity;
    }

    public Product setMinimalQuantity(double minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
        return this;
    }

    public String getQuantifiedAs() {
        return quantifiedAs;
    }

    public Product setQuantifiedAs(String quantifiedAs) {
        this.quantifiedAs = quantifiedAs;
        return this;
    }

    public int getStock() {
        return stock;
    }

    public Product setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public Product setOnSale(boolean onSale) {
        this.onSale = onSale;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", seller=" + seller +
                ", onSale=" + onSale +
                ", price=" + price +
                ", country='" + country + '\'' +
                ", minimalQuantity=" + minimalQuantity +
                ", stock=" + stock +
                ", quantifiedAs='" + quantifiedAs + '\'' +
                '}';
    }
}

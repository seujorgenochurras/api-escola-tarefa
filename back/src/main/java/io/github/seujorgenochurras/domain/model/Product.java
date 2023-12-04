package io.github.seujorgenochurras.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name", length = 200)
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_fk")
    private Client seller;

    @Column(name = "on_sale")
    @NotNull
    private boolean is_active = false;


    @NotNull
    @Column(name = "price", precision = 2)
    private Double price;

    @NotNull
    @Column(name = "category")
    private String category;


    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
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

    public Client getSeller() {
        return seller;
    }

    public Product setSeller(Client seller) {
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

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public Product setIs_active(boolean is_active) {
        this.is_active = is_active;
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
                ", onSale=" + is_active +
                ", price=" + price +
                ", quantifiedAs='" + category + '\'' +
                '}';
    }
}

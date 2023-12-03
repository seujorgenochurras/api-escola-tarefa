package io.github.seujorgenochurras.front.domain;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product extends RecursiveTreeObject<Product> {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();

    //TODO not being used
    private final SimpleStringProperty category = new SimpleStringProperty();
    private final SimpleDoubleProperty price = new SimpleDoubleProperty();
    private final SimpleStringProperty description = new SimpleStringProperty();

    private final SimpleIntegerProperty soldAmount = new SimpleIntegerProperty();

    public int getSoldAmount() {
        return soldAmount.get();
    }

    public SimpleIntegerProperty soldAmountProperty() {
        return soldAmount;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount.set(soldAmount);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public Product setId(int id) {
        this.id.set(id);
        return this;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public Product setName(String name) {
        this.name.set(name);
        return this;
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public Product setCategory(String category) {
        this.category.set(category);
        return this;
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public Product setPrice(double price) {
        this.price.set(price);
        return this;
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public Product setDescription(String description) {
        this.description.set(description);
        return this;
    }
}

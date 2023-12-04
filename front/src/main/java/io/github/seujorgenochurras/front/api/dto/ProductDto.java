package io.github.seujorgenochurras.front.api.dto;

public class ProductDto {
    private String name;

    //TODO not being used
    private String category;
    private Double price;
    private String description;

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

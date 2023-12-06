package io.github.seujorgenochurras.front.api.dto;

public class ProductCartDto {
    private ProductDto productDto;
    private Integer count;

    public ProductDto getProductDto() {
        return productDto;
    }

    public ProductCartDto setProductDto(ProductDto productDto) {
        this.productDto = productDto;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public ProductCartDto setCount(Integer count) {
        this.count = count;
        return this;
    }
}

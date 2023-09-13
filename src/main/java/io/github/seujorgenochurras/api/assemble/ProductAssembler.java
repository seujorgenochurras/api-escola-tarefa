package io.github.seujorgenochurras.api.assemble;

import io.github.seujorgenochurras.api.dto.ProductDto;
import io.github.seujorgenochurras.domain.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductAssembler {
    public Product toEntity(ProductDto productDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productDto, Product.class);
    }
}

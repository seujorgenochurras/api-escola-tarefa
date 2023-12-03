package io.github.seujorgenochurras.api.assemble;

import io.github.seujorgenochurras.api.dto.ProductDto;
import io.github.seujorgenochurras.domain.model.Product;
import io.github.seujorgenochurras.domain.model.Seller;
import io.github.seujorgenochurras.domain.service.SellerService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductAssembler {

    @Autowired
    private SellerService sellerService;


    public Product toEntity(ProductDto productDto) {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, Seller> sellerConverter = sellerUUID -> sellerService.getSellerById(sellerUUID.getSource());
        modelMapper.typeMap(ProductDto.class, Product.class)
                .addMappings(mapper -> mapper.using(sellerConverter).map(ProductDto::getSeller, Product::setSeller));

        return modelMapper.map(productDto, Product.class);
    }
}

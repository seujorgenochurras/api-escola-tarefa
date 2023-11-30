package io.github.seujorgenochurras.api.assemble;

import io.github.seujorgenochurras.api.dto.ProductOrderDto;
import io.github.seujorgenochurras.domain.model.ProductOrder;
import io.github.seujorgenochurras.domain.service.ClientService;
import io.github.seujorgenochurras.domain.service.ProductService;
import io.github.seujorgenochurras.domain.service.SellerService;
import jakarta.persistence.Column;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderAssembler {


    @Autowired
    private ClientService clientService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ProductService productService;



    public ProductOrder assemble(ProductOrderDto productOrderDto) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(productOrderDto, ProductOrder.class);

    }
}

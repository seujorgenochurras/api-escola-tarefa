package io.github.seujorgenochurras.api.assemble;

import io.github.seujorgenochurras.api.dto.ProductOrderDto;
import io.github.seujorgenochurras.domain.model.*;
import io.github.seujorgenochurras.domain.service.ClientService;
import io.github.seujorgenochurras.domain.service.ProductOrderService;
import io.github.seujorgenochurras.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderAssembler {


    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductOrderService productOrderService;

    public ProductOrder assemble(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = new ProductOrder();

        Product product = productService.findById(productOrderDto.getProduct());
        Client client = clientService.findClientByToken(productOrderDto.getClient());

        //BRUH
        if (client == null || product == null) return null;

        Client seller = product.getSeller();

        ClientAddress address = clientService.getClientAddress(client.getToken());
        if (address == null || seller == null) return null;

        productOrder
                .setAmount(productOrderDto.getAmount())
                .setOrderStatus(OrderStatus.PENDING)
                .setTotalPrice(product.getPrice() * productOrderDto.getAmount())
                .setSeller(seller)
                .setProduct(product)
                .setAddress(address.getAddress());
        return productOrder;


    }
}

package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.model.Product;
import io.github.seujorgenochurras.domain.model.ProductOrder;
import io.github.seujorgenochurras.domain.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;


    public List<ProductOrder> getClientOrders(Client client){
        return productOrderRepository.findByClient(client);
    }
}

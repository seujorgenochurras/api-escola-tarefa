package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.api.controller.ClientController;
import io.github.seujorgenochurras.api.dto.ProductOrderDto;
import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.model.Product;
import io.github.seujorgenochurras.domain.model.ProductOrder;
import io.github.seujorgenochurras.domain.repository.ClientRepository;
import io.github.seujorgenochurras.domain.service.exception.ProductOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private ProductService productService;

    @Transient
    public Client save(Client client){
        client.setId(UUID.randomUUID().toString());
       return clientRepository.save(client);

    }
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public ProductOrder order(ProductOrder order){
        Product product = productService.findById(order.get)
        if(!product.isOnSale()){
            throw new ProductOrderException("Product is not on sale");
        }
        ProductOrder productOrder = new ProductOrder();
        productOrder.setId(UUID.randomUUID().toString())
                .setClient(client)
                .setAmount()

    }

}

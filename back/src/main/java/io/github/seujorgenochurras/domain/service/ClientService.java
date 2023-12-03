package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.repository.ClientRepository;
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
       return clientRepository.save(client);
    }

    public Client getClientAccountInfo(String clientToken){
        System.out.println(clientToken);
        return clientRepository.findById(clientToken).orElse(null);
    }


    @Transient
    public Client register(Client client){
        client.setToken(UUID.randomUUID().toString());
        return clientRepository.save(client);

    }

    @Transient
    public Client login(String clientToken){
        return clientRepository.findById(clientToken).orElse(null);
    }
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
}

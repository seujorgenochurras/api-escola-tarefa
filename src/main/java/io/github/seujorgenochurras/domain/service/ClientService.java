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

    @Transient
    public Client save(Client client){
        client.setId(UUID.randomUUID().toString());
       return clientRepository.save(client);

    }
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

}

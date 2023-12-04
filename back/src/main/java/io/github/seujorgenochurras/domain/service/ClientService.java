package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.api.dto.RegisterInfoDto;
import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.model.ClientInfo;
import io.github.seujorgenochurras.domain.repository.ClientInfoRepository;
import io.github.seujorgenochurras.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientInfoRepository clientInfoRepository;

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private ProductService productService;


    public ClientInfo registerInfo(RegisterInfoDto clientInfoDto) {
        Client clientFound = findClientByToken(clientInfoDto.getClientToken());
        if (clientFound == null
                || getClientInfo(clientFound.getToken()) != null) {
            return null;
        }
        ClientInfo clientInfo = new ClientInfo();
        clientInfo
                .setClientToken(clientFound)
                .setCpf(clientInfoDto.getCpf())
                .setEmail(clientInfoDto.getEmail())
                .setName(clientInfoDto.getName())
                .setPhoneNumber(clientInfoDto.getPhoneNumber());
        return clientInfoRepository.save(clientInfo);
    }

    public Client getClientAccountInfo(String clientToken) {
        return clientRepository.findById(clientToken).orElse(null);
    }

    public ClientInfo getClientInfo(String clientToken) {
        return clientInfoRepository.findByClient(clientToken).orElse(null);
    }


    @Transient
    public Client register(Client client) {
        if (getClientByName(client.getUsername()) != null) {
            return null;
        }
        return clientRepository.save(client);
    }

    @Transient
    public Client getClientByName(String username) {
        return clientRepository.findByUsername(username).orElse(null);

    }

    @Transient
    public Client findClientByToken(String clientToken) {
        return clientRepository.findById(clientToken).orElse(null);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}

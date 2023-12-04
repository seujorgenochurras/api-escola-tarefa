package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.api.dto.ClientAddressDto;
import io.github.seujorgenochurras.api.dto.ClientAddressRegisterDto;
import io.github.seujorgenochurras.api.dto.RegisterInfoDto;
import io.github.seujorgenochurras.domain.model.Address;
import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.model.ClientAddress;
import io.github.seujorgenochurras.domain.model.ClientInfo;
import io.github.seujorgenochurras.domain.repository.ClientInfoRepository;
import io.github.seujorgenochurras.domain.repository.ClientRepository;
import jakarta.annotation.Nullable;
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

    @Autowired
    private AddressService addressService;

    @Autowired
    private ClientAddressService clientAddressService;

    public ClientInfo registerInfo(RegisterInfoDto clientInfoDto) {
        Client clientFound = findClientByToken(clientInfoDto.getClientToken());
        if (clientFound == null || getClientInfo(clientFound.getToken()) != null) {
            return null;
        }
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientToken(clientFound).setCpf(clientInfoDto.getCpf()).setEmail(clientInfoDto.getEmail()).setName(clientInfoDto.getName()).setPhoneNumber(clientInfoDto.getPhoneNumber());
        return clientInfoRepository.save(clientInfo);
    }

    public Client getClientAccountInfo(String clientToken) {
        return clientRepository.findById(clientToken).orElse(null);
    }

    public ClientInfo getClientInfo(String clientToken) {
        return clientInfoRepository.findByClient(clientToken).orElse(null);
    }

    public ClientAddress registerAddress(ClientAddressRegisterDto registerDto) {
        if(getClientAddress(registerDto.getClientToken()) != null) return null;
        Address persistedAddress = addressService.save(registerDto.getAddress());
        Client client = findClientByToken(registerDto.getClientToken());
        if (persistedAddress == null || client == null) {
            return null;
        }
        ClientAddressDto clientAddressDto = new ClientAddressDto();
        clientAddressDto.setAddress(persistedAddress);
        clientAddressDto.setClient(client);

        return clientAddressService.save(clientAddressDto);

    }
    public ClientAddress getClientAddress(String clientToken){
        return clientAddressService.findByClient(clientToken);
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
    @Nullable
    public Client findClientByToken(String clientToken) {
        return clientRepository.findById(clientToken).orElse(null);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}

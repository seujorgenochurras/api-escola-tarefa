package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.api.dto.ClientAddressDto;
import io.github.seujorgenochurras.domain.model.ClientAddress;
import io.github.seujorgenochurras.domain.repository.ClientAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientAddressService {

    @Autowired
    private ClientAddressRepository clientAddressRepository;

    public ClientAddress save(ClientAddressDto clientAddressDto){

        ClientAddress clientAddress = new ClientAddress();
        clientAddress.setAddress(clientAddressDto.getAddress());
        clientAddress.setClient(clientAddressDto.getClient());
        return clientAddressRepository.save(clientAddress);
    }
    public ClientAddress findByClient(String clientToken){
        return clientAddressRepository.findByClient(clientToken).orElse(null);
    }
}

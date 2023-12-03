package io.github.seujorgenochurras.api.assemble;


import io.github.seujorgenochurras.api.dto.ClientRegisterDto;
import io.github.seujorgenochurras.api.util.HashUtil;
import io.github.seujorgenochurras.domain.model.Client;
import org.springframework.stereotype.Component;


@Component
public class ClientDtoAssembler {

    public Client assembleRegistration(ClientRegisterDto clientDto){
        Client client = new Client();
        client.setUsername(clientDto.getUsername());
        client.setIsSeller(clientDto.isSeller());
        client.setToken(HashUtil.toSHA1((clientDto.getUsername()+clientDto.getPassword()).getBytes()));
        return client;
    }
}

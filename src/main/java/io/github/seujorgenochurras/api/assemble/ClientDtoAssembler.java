package io.github.seujorgenochurras.api.assemble;


import io.github.seujorgenochurras.api.dto.ClientRegisterDto;
import io.github.seujorgenochurras.domain.model.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ClientDtoAssembler {


    public Client assembleRegistration(ClientRegisterDto clientDto){
        return new ModelMapper().map(clientDto, Client.class);
    }
}

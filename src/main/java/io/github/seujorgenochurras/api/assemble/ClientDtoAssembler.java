package io.github.seujorgenochurras.api.assemble;


import io.github.seujorgenochurras.api.dto.ClientRegisterDto;
import io.github.seujorgenochurras.domain.model.Client;

public class ClientDtoAssembler {
    private ClientDtoAssembler(){}

    public static Client assembleRegistration(ClientRegisterDto clientDto){
        return new Client()
                .setAddress(clientDto.getAddress())
                .setAge(clientDto.getAge())
                .setGender(clientDto.getGender())
                .setName(clientDto.getName());
    }
}

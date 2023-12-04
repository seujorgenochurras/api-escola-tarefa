package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.api.dto.AddressDto;
import io.github.seujorgenochurras.domain.model.Address;
import io.github.seujorgenochurras.domain.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address save(AddressDto addressDto){
        Address address = new Address();
        address
                .setAddressNumber(addressDto.getAddressNumber())
                .setCity(addressDto.getCity())
                .setAdditionalInfo(addressDto.getAdditionalInfo())
                .setState(addressDto.getState())
                .setCepCode(addressDto.getCep())
                .setStreetName(addressDto.getStreetName())
                .setNeightboorhood(addressDto.getNeightboorhood());
        addressRepository.save(address);
        return address;
    }
}

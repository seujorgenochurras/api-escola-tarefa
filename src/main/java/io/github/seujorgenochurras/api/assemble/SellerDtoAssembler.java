package io.github.seujorgenochurras.api.assemble;

import io.github.seujorgenochurras.api.dto.SellerRegisterDto;
import io.github.seujorgenochurras.domain.model.Seller;
import io.github.seujorgenochurras.domain.repository.SellerRepository;

public class SellerDtoAssembler {

    public static Seller assembleRegistrationDto(SellerRegisterDto sellerRegisterDto){
        return new Seller()
                .setAddress(sellerRegisterDto.getAddress())
                .setName(sellerRegisterDto.getName());
    }
}

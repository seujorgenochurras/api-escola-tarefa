package io.github.seujorgenochurras.api.assemble;

import io.github.seujorgenochurras.api.dto.SellerRegisterDto;
import io.github.seujorgenochurras.domain.model.Seller;
import org.hibernate.annotations.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SellerDtoAssembler {

    public Seller assembleRegistrationDto(SellerRegisterDto sellerRegisterDto){
        return new ModelMapper().map(sellerRegisterDto, Seller.class);
    }
}

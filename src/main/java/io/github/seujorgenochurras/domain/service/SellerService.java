package io.github.seujorgenochurras.domain.service;

import io.github.seujorgenochurras.api.dto.SellerRegisterDto;
import io.github.seujorgenochurras.domain.model.Seller;
import io.github.seujorgenochurras.domain.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller save(Seller seller){
        sellerRepository.save(seller);
        return null;
    }
    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }


}

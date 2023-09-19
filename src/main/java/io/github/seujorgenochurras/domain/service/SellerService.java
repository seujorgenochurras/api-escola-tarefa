package io.github.seujorgenochurras.domain.service;

import com.sun.java.accessibility.util.GUIInitializedListener;
import io.github.seujorgenochurras.api.dto.SellerRegisterDto;
import io.github.seujorgenochurras.domain.model.Seller;
import io.github.seujorgenochurras.domain.repository.SellerRepository;
import io.github.seujorgenochurras.domain.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller save(Seller seller){
        seller.setId(UUID.randomUUID().toString());
        return sellerRepository.save(seller);
    }
    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }

    public Seller getSellerById(String sellerUUID){
        return sellerRepository.findById(sellerUUID).orElseThrow(() -> new NotFoundException("Seller not found"));
    }

}

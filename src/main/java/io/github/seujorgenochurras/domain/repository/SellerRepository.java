package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, String> {
}

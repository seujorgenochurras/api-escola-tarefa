package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends JpaRepository<Seller, String> {
}

package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


    @Query("select * from product where product.isActive = true")
    List<Product> findALlActiveProducts();
}

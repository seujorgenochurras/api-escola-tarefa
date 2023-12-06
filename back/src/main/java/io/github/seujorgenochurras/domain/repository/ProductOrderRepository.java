package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, String> {

    @Query(value = "select * from product_order where client_fk = ?1", nativeQuery = true)
    List<ProductOrder> findAllByClient(String client);

}

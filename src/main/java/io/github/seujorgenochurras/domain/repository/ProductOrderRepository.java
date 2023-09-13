package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, String> {
    List<ProductOrder> findByClient(Client client);

}

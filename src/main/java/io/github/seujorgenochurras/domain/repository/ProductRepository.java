package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}

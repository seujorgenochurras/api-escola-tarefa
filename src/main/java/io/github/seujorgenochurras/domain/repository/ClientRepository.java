package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
}

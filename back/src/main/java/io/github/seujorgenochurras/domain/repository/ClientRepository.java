package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    Optional<Client> findByUsername(String username);

}

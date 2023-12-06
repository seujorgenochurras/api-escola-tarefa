package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.Client;
import io.github.seujorgenochurras.domain.model.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientAddressRepository extends JpaRepository<ClientAddress, Integer> {

    @Query(value = "select * from client_address where client_fk = ?1", nativeQuery = true)
    Optional<ClientAddress> findByClient(String clientToken);
}

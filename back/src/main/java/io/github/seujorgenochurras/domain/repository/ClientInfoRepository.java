package io.github.seujorgenochurras.domain.repository;

import io.github.seujorgenochurras.domain.model.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientInfoRepository extends JpaRepository<ClientInfo, Integer> {
    @Query(value = "select * from client_info where client_token = ?1", nativeQuery = true)
    Optional<ClientInfo> findByClient(String clientId);
}

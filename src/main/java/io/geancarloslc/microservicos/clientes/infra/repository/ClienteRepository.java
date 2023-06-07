package io.geancarloslc.microservicos.clientes.infra.repository;

import io.geancarloslc.microservicos.clientes.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
}

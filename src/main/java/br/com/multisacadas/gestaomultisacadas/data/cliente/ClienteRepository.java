package br.com.multisacadas.gestaomultisacadas.data.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    boolean existsByCpfCnpj(String cpfCnpj);
}

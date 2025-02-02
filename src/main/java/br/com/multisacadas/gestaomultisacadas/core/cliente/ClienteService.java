package br.com.multisacadas.gestaomultisacadas.core.cliente;

import br.com.multisacadas.gestaomultisacadas.data.cliente.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll().stream()
            .map(ClienteMapper::toDomain)
            .toList();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
            .map(ClienteMapper::toDomain)
            .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

    public Cliente salvar(Cliente cliente) {
        var clienteEntity = ClienteMapper.toEntity(cliente);
        return ClienteMapper.toDomain(clienteRepository.save(clienteEntity));
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}

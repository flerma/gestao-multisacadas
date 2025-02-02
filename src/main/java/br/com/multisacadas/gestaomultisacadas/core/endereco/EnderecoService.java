package br.com.multisacadas.gestaomultisacadas.core.endereco;

import br.com.multisacadas.gestaomultisacadas.data.endereco.EnderecoEntity;
import br.com.multisacadas.gestaomultisacadas.data.endereco.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public List<EnderecoEntity> listarTodos() {
        return enderecoRepository.findAll();
    }

    public EnderecoEntity buscarPorId(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));
    }

    public EnderecoEntity salvar(EnderecoEntity endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deletar(Long id) {
        enderecoRepository.deleteById(id);
    }
}
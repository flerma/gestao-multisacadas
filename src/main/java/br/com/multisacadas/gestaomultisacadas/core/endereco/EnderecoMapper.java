package br.com.multisacadas.gestaomultisacadas.core.endereco;

import br.com.multisacadas.gestaomultisacadas.data.endereco.EnderecoEntity;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public static Endereco toDomain(EnderecoEntity endereco) {
        return Endereco.builder()
            .id(endereco.getId())
            .endereco(endereco.getEndereco())
            .numero(endereco.getNumero())
            .complemento(endereco.getComplemento())
            .bairro(endereco.getBairro())
            .cidade(endereco.getCidade())
            .estado(endereco.getEstado())
            .cep(endereco.getCep())
            .build();
    }

    public static EnderecoEntity toEntity(Endereco dominio) {
        return EnderecoEntity.builder()
            .id(dominio.getId())
            .endereco(dominio.getEndereco())
            .numero(dominio.getNumero())
            .complemento(dominio.getComplemento())
            .bairro(dominio.getBairro())
            .cidade(dominio.getCidade())
            .estado(dominio.getEstado())
            .cep(dominio.getCep())
            .build();
    }
}
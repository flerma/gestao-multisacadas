package br.com.multisacadas.gestaomultisacadas.core.cliente;

import br.com.multisacadas.gestaomultisacadas.core.endereco.EnderecoMapper;
import br.com.multisacadas.gestaomultisacadas.data.cliente.ClienteEntity;

public class ClienteMapper {
    public static Cliente toDomain(ClienteEntity entidade) {
        return Cliente.builder()
            .id(entidade.getId())
            .nome(entidade.getNome())
            .cpfCnpj(entidade.getCpfCnpj())
            .rg(entidade.getRg())
            .email(entidade.getEmail())
            .telefone(entidade.getTelefone())
            .enderecos(entidade.getEnderecos().stream().map(EnderecoMapper::toDomain).toList())
            .build();
    }

    public static ClienteEntity toEntity(Cliente dominio) {
        return ClienteEntity.builder()
            .id(dominio.getId())
            .nome(dominio.getNome())
            .cpfCnpj(dominio.getCpfCnpj())
            .rg(dominio.getRg())
            .email(dominio.getEmail())
            .telefone(dominio.getTelefone())
            .enderecos(dominio.getEnderecos().stream().map(EnderecoMapper::toEntity).toList())
            .build();
    }
}
package br.com.multisacadas.gestaomultisacadas.core.cliente;

import br.com.multisacadas.gestaomultisacadas.core.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String rg;
    private String email;
    private String telefone;
    private List<Endereco> enderecos;
}

package io.geancarloslc.microservicos.clientes.domain.dto;

import io.geancarloslc.microservicos.clientes.domain.entity.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {
    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel() {
        return new Cliente(cpf, nome, idade);
    }

}

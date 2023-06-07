package io.geancarloslc.microservicos.clientes.service;

import io.geancarloslc.microservicos.clientes.domain.entity.Cliente;
import io.geancarloslc.microservicos.clientes.infra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarCliente (String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

}

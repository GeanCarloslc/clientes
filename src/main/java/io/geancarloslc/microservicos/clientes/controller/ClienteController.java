package io.geancarloslc.microservicos.clientes.controller;

import io.geancarloslc.microservicos.clientes.domain.entity.Cliente;
import io.geancarloslc.microservicos.clientes.domain.dto.ClienteDTO;
import io.geancarloslc.microservicos.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity salvarCliente(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteDTO.toModel();
        clienteService.salvar(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Cliente> buscarCliente(@RequestParam("cpf") String cpf)  {
        Optional<Cliente> cliente = clienteService.buscarCliente(cpf);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

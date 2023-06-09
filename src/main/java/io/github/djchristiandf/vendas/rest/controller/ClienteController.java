package io.github.djchristiandf.vendas.rest.controller;

import io.github.djchristiandf.vendas.domain.entity.Cliente;
import io.github.djchristiandf.vendas.domain.repositorio.ClientesJpaRepositoryInterface;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController  {
    private ClientesJpaRepositoryInterface clientes;

    public ClienteController(ClientesJpaRepositoryInterface clientes) {
        this.clientes = clientes;
    }

    @GetMapping(value="{id}")
    public Cliente getClienteById( @PathVariable Integer id ){
        return clientes.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente nao encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente){
        return clientes.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id){
        clientes.findById(id).map(cliente -> {
            clientes.delete(cliente);
            return cliente;
        }).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado")
        );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id, @RequestBody Cliente cli){
        clientes.findById(id).map( clienteExistente -> {
            cli.setId(clienteExistente.getId());
            clientes.save(cli);
            return clienteExistente;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Cliente> find(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(
                ExampleMatcher.StringMatcher.CONTAINING
        );
        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);
    }
}

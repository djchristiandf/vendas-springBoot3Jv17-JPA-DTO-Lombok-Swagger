package io.github.djchristiandf.vendas.domain.repositorio;

import io.github.djchristiandf.vendas.domain.entity.Cliente;
import io.github.djchristiandf.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}

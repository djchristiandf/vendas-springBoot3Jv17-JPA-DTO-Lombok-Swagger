package io.github.djchristiandf.vendas.domain.repositorio;

import io.github.djchristiandf.vendas.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}

package io.github.djchristiandf.vendas.domain.repositorio;

import io.github.djchristiandf.vendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}

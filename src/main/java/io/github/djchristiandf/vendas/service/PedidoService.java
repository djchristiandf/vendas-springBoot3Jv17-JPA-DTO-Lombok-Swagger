package io.github.djchristiandf.vendas.service;

import io.github.djchristiandf.vendas.domain.entity.Pedido;
import io.github.djchristiandf.vendas.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}

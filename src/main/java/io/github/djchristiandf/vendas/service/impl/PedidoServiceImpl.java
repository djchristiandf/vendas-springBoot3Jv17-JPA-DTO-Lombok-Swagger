package io.github.djchristiandf.vendas.service.impl;

import io.github.djchristiandf.vendas.domain.entity.Pedido;
import io.github.djchristiandf.vendas.domain.repositorio.ClientesJpaRepositoryInterface;
import io.github.djchristiandf.vendas.domain.repositorio.Pedidos;
import io.github.djchristiandf.vendas.domain.repositorio.Produtos;
import io.github.djchristiandf.vendas.rest.dto.PedidoDTO;
import io.github.djchristiandf.vendas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final Pedidos repository;
    private final ClientesJpaRepositoryInterface clientesRepository;
    private final Produtos produtos;

    @Override
    public Pedido salvar(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        //pedido.setCliente();

        return null;
    }
}

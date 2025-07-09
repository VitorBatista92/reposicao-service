package br.com.postechfiap.reposicao_estoque.infraestructure.controller.adapter;

import br.com.postechfiap.reposicao_estoque.domain.entities.Pedido;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.CreatePedidoDto;
import org.springframework.stereotype.Component;

@Component
public class PedidoAdapter {
    public Pedido toReposicao(CreatePedidoDto pedidoDto){
        return Pedido.builder()
                .sku(pedidoDto.sku())
                .status(pedidoDto.status())
                .laboratorio(pedidoDto.laboratorio())
                .build();
    }
}

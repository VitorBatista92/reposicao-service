package br.com.postechfiap.reposicao_estoque.application.usecases;

import br.com.postechfiap.reposicao_estoque.application.gateways.PedidoGateway;
import br.com.postechfiap.reposicao_estoque.application.interfaces.CreatePedidoUseCase;
import br.com.postechfiap.reposicao_estoque.infraestructure.controller.adapter.PedidoResponseAdapter;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.PedidoRequest;
import br.com.postechfiap.reposicao_estoque.infraestructure.persistance.entities.PedidoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePedidoUseCaseImpl implements CreatePedidoUseCase {

    private final PedidoGateway pedidoGateway;
    private final PedidoResponseAdapter pedidoResponseAdapter;
    @Override
    public PedidoResponse execute(PedidoRequest reposicao) {
        var pedido = PedidoEntity.builder()
                .sku(reposicao.sku())
                .laboratorio(reposicao.laboratorio())
                .status("aberto")
                .build();

        final var pedidoSalveo = pedidoGateway.save(pedido);

        PedidoResponse pedidoResponse = pedidoResponseAdapter.adapt(pedidoSalveo);

        return pedidoResponse;
    }
}

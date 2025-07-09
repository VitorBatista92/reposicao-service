package br.com.postechfiap.reposicao_estoque.application.usecases;

import br.com.postechfiap.reposicao_estoque.application.gateways.PedidoGateway;
import br.com.postechfiap.reposicao_estoque.application.interfaces.UpdateReposicaoUseCase;
import br.com.postechfiap.reposicao_estoque.infraestructure.controller.adapter.PedidoResponseAdapter;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.AtualizaPedidoRequest;
import br.com.postechfiap.reposicao_estoque.infraestructure.exceptions.PedidoNotFoundException;
import br.com.postechfiap.reposicao_estoque.infraestructure.persistance.entities.PedidoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePedidoUseCaseImpl  implements UpdateReposicaoUseCase {

    private final PedidoResponseAdapter pedidoResponseAdapter;
    private final PedidoGateway pedidoGateway;
    @Override
    public PedidoResponse execute(AtualizaPedidoRequest reposicao) {
        final var reposicaoAchada = pedidoGateway.findById(reposicao.id())
                .orElseThrow(PedidoNotFoundException::new);
        final var pedidoAtualizado =  PedidoEntity.builder()
                .id(reposicao.id())
                .sku(reposicao.sku())
                .laboratorio(reposicao.laboratorio())
                .status(reposicao.status())
                .build();

        final var pedidoSalvo = pedidoGateway.update(pedidoAtualizado);

        PedidoResponse pedidoResponse = pedidoResponseAdapter.adapt(pedidoSalvo);

        return pedidoResponse;
    }
}

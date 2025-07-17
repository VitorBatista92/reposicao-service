package br.com.postechfiap.reposicao_estoque.application.usecases;

import br.com.postechfiap.reposicao_estoque.application.gateways.PedidoGateway;
import br.com.postechfiap.reposicao_estoque.application.interfaces.usecases.NotificaReposicaoUseCase;
import br.com.postechfiap.reposicao_estoque.infraestructure.controller.adapter.PedidoResponseAdapter;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.laboratorio.LaboratorioResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.NotificaReposicaoRequest;
import br.com.postechfiap.reposicao_estoque.infraestructure.exceptions.PedidoNotFoundException;
import br.com.postechfiap.reposicao_estoque.infraestructure.gateways.MedicamentoClient;
import br.com.postechfiap.reposicao_estoque.infraestructure.listener.dto.AlterarEstoqueRequest;
import br.com.postechfiap.reposicao_estoque.infraestructure.persistance.entities.PedidoEntity;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class NotificaReposicaoUseCaseImpl implements NotificaReposicaoUseCase {

    private final PedidoResponseAdapter pedidoResponseAdapter;
    private final PedidoGateway pedidoGateway;
    private final MedicamentoClient medicamentoClient;

    public PedidoResponse execute(NotificaReposicaoRequest reposicao) {
        LaboratorioResponse laboratorioResponse;
        final var reposicaoAchada = pedidoGateway.findBySku(reposicao.sku())
                .orElseThrow(PedidoNotFoundException::new);

        try {
            laboratorioResponse = medicamentoClient.adicionarPorSku(new AlterarEstoqueRequest(reposicao.sku(), reposicao.numero()));
        } catch (FeignException.NotFound e) {
            throw e;
        }

        final var pedidoAtualizado =  PedidoEntity.builder()
                .id(reposicaoAchada.getId())
                .sku(reposicaoAchada.getSku())
                .laboratorioId(reposicaoAchada.getLaboratorioId())
                .status("Concluido")
                .build();

        final var pedidoSalvo = pedidoGateway.update(pedidoAtualizado);

        PedidoResponse pedidoResponse = pedidoResponseAdapter.adapt(pedidoSalvo);

        return pedidoResponse;
    }

}

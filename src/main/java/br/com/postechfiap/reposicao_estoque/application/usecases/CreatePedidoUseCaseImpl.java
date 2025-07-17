package br.com.postechfiap.reposicao_estoque.application.usecases;

import br.com.postechfiap.reposicao_estoque.application.gateways.PedidoGateway;
import br.com.postechfiap.reposicao_estoque.application.interfaces.usecases.CreatePedidoUseCase;
import br.com.postechfiap.reposicao_estoque.infraestructure.controller.adapter.PedidoResponseAdapter;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.laboratorio.LaboratorioResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.PedidoRequest;
import br.com.postechfiap.reposicao_estoque.infraestructure.exceptions.LaboratorioNotFoundException;
import br.com.postechfiap.reposicao_estoque.infraestructure.gateways.LaboratorioClient;
import br.com.postechfiap.reposicao_estoque.infraestructure.persistance.entities.PedidoEntity;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableFeignClients
public class CreatePedidoUseCaseImpl implements CreatePedidoUseCase {

    private final PedidoGateway pedidoGateway;
    private final PedidoResponseAdapter pedidoResponseAdapter;

    private final LaboratorioClient laboratorioClient;

    @Override
    public PedidoResponse execute(PedidoRequest reposicao) {

        LaboratorioResponse laboratorioResponse;
        try {
            laboratorioResponse = laboratorioClient.buscarFornecedorPorId(reposicao.laboratorioId());
        } catch (FeignException.NotFound e) {
            throw new LaboratorioNotFoundException(reposicao.laboratorioId());
        }

        var pedido = PedidoEntity.builder()
                .sku(reposicao.sku())
                .laboratorioId(reposicao.laboratorioId())
                .status("aberto")
                .build();

        final var pedidoSalveo = pedidoGateway.save(pedido);

        PedidoResponse pedidoResponse = pedidoResponseAdapter.adapt(pedidoSalveo);

        return pedidoResponse;
    }
}

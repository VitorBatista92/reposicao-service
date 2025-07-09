package br.com.postechfiap.reposicao_estoque.application.usecases;

import br.com.postechfiap.reposicao_estoque.application.gateways.PedidoGateway;
import br.com.postechfiap.reposicao_estoque.application.interfaces.BuscaPedidoUseCase;
import br.com.postechfiap.reposicao_estoque.infraestructure.controller.adapter.PedidoResponseAdapter;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.PedidoRequestParams;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BuscaPedidoUseCaseImpl implements BuscaPedidoUseCase {

    private final PedidoResponseAdapter pedidoResponseAdapter;
    private final PedidoGateway reposicaoRepository;
    @Override
    public List<PedidoResponse> execute(PedidoRequestParams parametros) {
        final var id = Optional.ofNullable(parametros.getId()).orElse(-1l);
        final var sku = Optional.ofNullable(parametros.getSku()).orElse("");
        final var reposicaoAchada = reposicaoRepository.findByRequestParams(id, sku).orElseThrow();
        final var resposta = reposicaoAchada
                .stream()
                .map(pedidoResponseAdapter::adapt)
                .toList();
        return resposta;
    }
}

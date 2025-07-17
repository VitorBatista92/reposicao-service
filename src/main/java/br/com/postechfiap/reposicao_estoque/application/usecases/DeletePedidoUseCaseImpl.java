package br.com.postechfiap.reposicao_estoque.application.usecases;

import br.com.postechfiap.reposicao_estoque.application.gateways.PedidoGateway;
import br.com.postechfiap.reposicao_estoque.application.interfaces.usecases.DeletePedidoUseCase;
import br.com.postechfiap.reposicao_estoque.infraestructure.exceptions.PedidoNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeletePedidoUseCaseImpl implements DeletePedidoUseCase {
    private final PedidoGateway pedidoGateway;

    @Override
    public String execute(Long id) {
        final var pedido  = pedidoGateway.findById(id).orElseThrow(PedidoNotFoundException::new);
        pedidoGateway.delete(pedido);
        return pedido.getId().toString();
    }
}

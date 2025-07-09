package br.com.postechfiap.reposicao_estoque.application.interfaces;

import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.AtualizaPedidoRequest;

public interface UpdateReposicaoUseCase extends Usecase <AtualizaPedidoRequest, PedidoResponse> {
}

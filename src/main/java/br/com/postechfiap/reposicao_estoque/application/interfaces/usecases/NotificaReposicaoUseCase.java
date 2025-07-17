package br.com.postechfiap.reposicao_estoque.application.interfaces.usecases;

import br.com.postechfiap.reposicao_estoque.application.interfaces.Usecase;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.NotificaReposicaoRequest;

public interface NotificaReposicaoUseCase extends Usecase<NotificaReposicaoRequest, PedidoResponse> {
}

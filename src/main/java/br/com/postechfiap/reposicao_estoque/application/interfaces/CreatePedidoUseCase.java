package br.com.postechfiap.reposicao_estoque.application.interfaces;

import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.PedidoRequest;

public interface CreatePedidoUseCase extends Usecase <PedidoRequest, PedidoResponse>{
}

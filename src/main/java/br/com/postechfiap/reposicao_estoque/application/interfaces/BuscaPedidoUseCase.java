package br.com.postechfiap.reposicao_estoque.application.interfaces;

import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.PedidoRequestParams;

import java.util.List;

public interface BuscaPedidoUseCase extends Usecase <PedidoRequestParams, List<PedidoResponse>>{
}

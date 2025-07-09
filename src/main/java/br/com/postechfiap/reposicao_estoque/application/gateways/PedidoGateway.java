package br.com.postechfiap.reposicao_estoque.application.gateways;

import br.com.postechfiap.reposicao_estoque.infraestructure.persistance.entities.PedidoEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoGateway extends BaseGateway<PedidoEntity,Long> {
    Optional<PedidoEntity> findBySku(String sku);
    Optional<List<PedidoEntity>> findByRequestParams(Long id, String sku);
    Optional<List<PedidoEntity>> findAllByRequestParams(Long id, String sku);

}

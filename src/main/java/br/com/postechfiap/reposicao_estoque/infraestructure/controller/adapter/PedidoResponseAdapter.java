package br.com.postechfiap.reposicao_estoque.infraestructure.controller.adapter;

import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.persistance.entities.PedidoEntity;
import br.com.postechfiap.reposicao_estoque.infraestructure.utils.JsonUtils;
import org.springframework.stereotype.Component;

@Component
public class PedidoResponseAdapter extends AbstractAdapter<PedidoEntity, PedidoResponse> {
    public PedidoResponseAdapter(JsonUtils jsonUtils) {
        super(PedidoResponse.class, jsonUtils);
    }
}

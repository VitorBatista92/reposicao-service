package br.com.postechfiap.reposicao_estoque.infraestructure.gateways;

import br.com.postechfiap.reposicao_estoque.application.configuration.LaboratorioFornecedorFeignClientConfig;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.laboratorio.LaboratorioResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.listener.dto.AlterarEstoqueRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(
        name = "${client.medicamento-service.name}",
        url = "${client.medicamento-service.url}",
        configuration = LaboratorioFornecedorFeignClientConfig.class
)
public interface MedicamentoClient {
    @PutMapping("adicionar")
    LaboratorioResponse adicionarPorSku(AlterarEstoqueRequest request);
}

package br.com.postechfiap.reposicao_estoque.infraestructure.gateways;

import br.com.postechfiap.reposicao_estoque.application.configuration.LaboratorioFornecedorFeignClientConfig;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.laboratorio.LaboratorioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "${client.fornecedor-service.name}",
        url = "${client.fornecedor-service.url}",
        configuration = LaboratorioFornecedorFeignClientConfig.class
)
public interface LaboratorioClient {
    @GetMapping("fornecedores/buscar/{id}")
    LaboratorioResponse buscarFornecedorPorId(@PathVariable("id") Long id);
}

package br.com.postechfiap.reposicao_estoque.application.configuration;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaboratorioFornecedorFeignClientConfig {

    @Value("${client.fornecedor-service.api-key}")
    private String LaboratorioServiceApiKey;

    @Bean
    public RequestInterceptor medicamentosServiceApiKeyInterceptor() {
        return requestTemplate -> requestTemplate.header("X-API-Key", LaboratorioServiceApiKey);
    }
}

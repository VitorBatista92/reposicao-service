package br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PedidoRequestParams {
    @Schema(description = "ID do pedido medicamento para busca.")
    private Long id;
    @Schema(description = "SKU (Stock Keeping Unit) do medicamento para busca.", example = "DIPIR-300MG35MG50MG-NEOSA-HYPE")
    private String sku;
}

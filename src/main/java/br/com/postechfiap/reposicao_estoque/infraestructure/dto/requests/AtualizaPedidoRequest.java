package br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record AtualizaPedidoRequest (
        @Schema(description = "Id do pedido para busca.", example = "DIPIR-300MG35MG50MG-NEOSA-HYPE")
        Long id,
        @Schema(description = "SKU (Stock Keeping Unit) do medicamento para busca.", example = "DIPIR-300MG35MG50MG-NEOSA-HYPE")
        String sku,
        @Schema(description = "Laboratorio do medicamento para busca.", example = "DIPIR-300MG35MG50MG-NEOSA-HYPE")
        String laboratorio,
        @Schema(description = "Status do pedido para atualizar.", example = "DIPIR-300MG35MG50MG-NEOSA-HYPE")
        String status

){}

package br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record PedidoRequest (
        @Schema(description = "SKU (Stock Keeping Unit) do medicamento para busca.", example = "DIPIR-300MG35MG50MG-NEOSA-HYPE")
        String sku,
        @Schema(description = "Laboratorio do medicamento para busca.", example = "DIPIR-300MG35MG50MG-NEOSA-HYPE")
        String laboratorio
){}

package br.com.postechfiap.reposicao_estoque.infraestructure.dto;

import jakarta.validation.constraints.NotBlank;

public record CreatePedidoDto (
        @NotBlank(message = "O sku é obrigatório.")
        String sku,

        @NotBlank(message = "O status é obrigatório.")
        String status,

        @NotBlank(message = "O laboratorio é obrigatório.")
        String laboratorio
){}

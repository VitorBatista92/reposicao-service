package br.com.postechfiap.reposicao_estoque.infraestructure.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
public class PedidoResponse {
    private int id;
    private String nome;
    private String status;
    private String laboratorio;
}

package br.com.postechfiap.reposicao_estoque.domain.entities;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido {
    private int id;
    private String sku;
    private String status;
    private String laboratorio;


}

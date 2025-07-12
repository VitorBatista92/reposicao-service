package br.com.postechfiap.reposicao_estoque.infraestructure.dto.laboratorio;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaboratorioResponse {
    private Long id;
    private String nome;
    private String cnpj;
}

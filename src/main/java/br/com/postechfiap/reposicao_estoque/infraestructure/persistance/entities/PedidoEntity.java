package br.com.postechfiap.reposicao_estoque.infraestructure.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder(toBuilder = true)
@Table(name = "reposicao")
@Entity
public class PedidoEntity extends BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reposicao_seq_generator")
    @SequenceGenerator(name = "reposicao_seq_generator", sequenceName = "reposicao_id_seq", allocationSize = 1)
    private Long id;

    @Setter
    @NotBlank(message = "O sku do pedido é obrigatório.")
    @Column(nullable = false, unique = true, updatable = true)
    private String sku;

    @Setter
    @NotBlank(message = "O status do pedido é obrigatorio")
    @Column(nullable = false)
    private String status;

    @Setter
    @NotBlank(message = "O laboratorio do pedido é obrigatorio")
    @Column(nullable = false)
    private String laboratorio;


}

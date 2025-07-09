package br.com.postechfiap.reposicao_estoque.infraestructure.persistance.repository;

import br.com.postechfiap.reposicao_estoque.infraestructure.persistance.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    Optional<PedidoEntity> findBySku(String sku);


    @Query("SELECT m FROM PedidoEntity m " +
            "WHERE (m.deletedTmsp is null ) " +
            "AND (-1 = :id OR m.id = :id) " +
            "AND ('' = :sku OR m.sku = :sku) "
    )
    Optional<List<PedidoEntity>> findByRequestParams(@Param("id") Long id,
                                                     @Param("sku") String sku
    );


    @Query("SELECT m FROM PedidoEntity m " +
            "WHERE (-1 = :id OR m.id = :id) " +
            "AND ('' = :sku OR m.sku = :sku) "
    )
    Optional<List<PedidoEntity>> findAllByRequestParams(@Param("id") Long id,
                                                        @Param("sku") String sku
    );
}

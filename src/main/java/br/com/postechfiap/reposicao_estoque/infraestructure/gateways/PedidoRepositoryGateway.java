package br.com.postechfiap.reposicao_estoque.infraestructure.gateways;

import br.com.postechfiap.reposicao_estoque.application.gateways.PedidoGateway;
import br.com.postechfiap.reposicao_estoque.infraestructure.persistance.entities.PedidoEntity;
import br.com.postechfiap.reposicao_estoque.infraestructure.persistance.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PedidoRepositoryGateway implements PedidoGateway {
    private final PedidoRepository pedidoRepository;
    @Override
    public Optional<PedidoEntity> findBySku(String sku) {
        return pedidoRepository.findBySku(sku);
    }

    @Override
    public PedidoEntity save(PedidoEntity entity) {
        return pedidoRepository.save(entity);
    }

    @Override
    public List<PedidoEntity> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<PedidoEntity> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public void delete(PedidoEntity entity) {
        entity.setDeletedTmsp(LocalDateTime.now());
        pedidoRepository.save(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public PedidoEntity update(PedidoEntity entity) {
        entity.setUpdatedAt(LocalDateTime.now());
        return pedidoRepository.save(entity);
    }

    @Override
    public Optional<List<PedidoEntity>> findByRequestParams(Long id, String sku) {
        var resposta = pedidoRepository.findByRequestParams(id, sku);
        return resposta;
    }

    @Override
    public Optional<List<PedidoEntity>> findAllByRequestParams(Long id, String sku) {
        var resposta = pedidoRepository.findAllByRequestParams(id, sku);
        return resposta;
    }
}

package br.com.postechfiap.reposicao_estoque.infraestructure.controller;

import br.com.postechfiap.reposicao_estoque.application.interfaces.BuscaPedidoUseCase;
import br.com.postechfiap.reposicao_estoque.application.interfaces.CreatePedidoUseCase;
import br.com.postechfiap.reposicao_estoque.application.interfaces.DeletePedidoUseCase;
import br.com.postechfiap.reposicao_estoque.application.interfaces.UpdateReposicaoUseCase;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.PedidoResponse;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.AtualizaPedidoRequest;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.PedidoRequest;
import br.com.postechfiap.reposicao_estoque.infraestructure.dto.requests.PedidoRequestParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reposicao")
@Tag(name = "Reposicao", description = "Api de pedidos de reposicao")
public class PedidoController {


    private final CreatePedidoUseCase createPedidoUseCase;
    private final BuscaPedidoUseCase buscaPedidoUseCase;
    private final UpdateReposicaoUseCase updateReposicaoUseCase;
    private final DeletePedidoUseCase deletePedidoUseCase;

    @PostMapping
    @Operation(summary = "Criar Pedido", description = "Cria o pedido de reposicao")
    public ResponseEntity criarPedido(@RequestBody PedidoRequest reposicao) {
        return new ResponseEntity<>(createPedidoUseCase.execute(reposicao), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Buscar Medicamento", description = "Buscar medicamento por nome ou sku")
    public ResponseEntity<List<PedidoResponse>> buscarMedicamento(@RequestParam(required = false) Long id,
                                                                  @RequestParam(required = false) String sku
                                                                        ) {
        final PedidoRequestParams requestParams = PedidoRequestParams.builder()
                .id(id)
                .sku(sku)
                .build();

        var medicamentoBuscado = buscaPedidoUseCase.execute(requestParams);


        return ResponseEntity.ok(medicamentoBuscado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza pedido de medicamento", description = "Atualizar pedido de medicamento por sku")
    public ResponseEntity<PedidoResponse> atualizarPedido(@PathVariable Long id,
                                                          @Valid @RequestBody AtualizaPedidoRequest atualizaPedidoRequest) {
        var pedido = updateReposicaoUseCase.execute(new AtualizaPedidoRequest(  atualizaPedidoRequest.id(),
                                                                                atualizaPedidoRequest.sku(),
                                                                                atualizaPedidoRequest.laboratorio(),
                                                                                atualizaPedidoRequest.status()));

        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Apaga o pedido de medicamento", description = "Apaga pedido de medicamento por sku")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id) {
        var response = deletePedidoUseCase.execute(id);
        return ResponseEntity.ok("O pedido de ID " + response + " foi removido com sucesso");
    }
}

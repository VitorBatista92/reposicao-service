package br.com.postechfiap.reposicao_estoque.infraestructure.exceptions;

import br.com.postechfiap.reposicao_estoque.infraestructure.exceptions.EntityNotFoundException;

public class PedidoNotFoundException extends EntityNotFoundException {
    public PedidoNotFoundException() {
        super("Estoque", "o");
    }
}

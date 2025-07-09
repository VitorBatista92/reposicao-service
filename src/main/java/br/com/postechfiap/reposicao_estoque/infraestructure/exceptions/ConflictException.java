package br.com.postechfiap.reposicao_estoque.infraestructure.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}

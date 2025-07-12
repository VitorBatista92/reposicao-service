package br.com.postechfiap.reposicao_estoque.infraestructure.exceptions;

public class LaboratorioNotFoundException extends ConflictException {

    public LaboratorioNotFoundException(Long id) { super("Laboratorio com ID: " + id + " nao encontrado."); }
}

package br.com.postechfiap.reposicao_estoque.application.interfaces;

public interface Usecase <Input,Output>{
    Output execute(Input input);
}

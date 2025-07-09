package br.com.postechfiap.reposicao_estoque.application.interfaces;

public interface Adapter<Source, Destination> {

    Destination adapt(Source source);

    Destination adapt(Source source, Destination destination);

}

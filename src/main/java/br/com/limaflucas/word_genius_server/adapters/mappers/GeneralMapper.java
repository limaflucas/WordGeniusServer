package br.com.limaflucas.word_genius_server.adapters.mappers;

public interface GeneralMapper<I,O> {

    default O to(I i) { throw new UnsupportedOperationException();}
    default I from(O o) {throw new UnsupportedOperationException();}
}

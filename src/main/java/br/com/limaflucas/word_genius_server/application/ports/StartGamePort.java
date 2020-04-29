package br.com.limaflucas.word_genius_server.application.ports;

import br.com.limaflucas.word_genius_server.application.dtos.StartedGameDTO;

public interface StartGamePort {

    StartedGameDTO start(StartedGameDTO startedGameDTO);
}

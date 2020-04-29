package br.com.limaflucas.word_genius_server.application;

import br.com.limaflucas.word_genius_server.application.dtos.GeniusResponseDTO;
import br.com.limaflucas.word_genius_server.application.dtos.StartGameDTO;

public interface UseCaseStartGame {

    GeniusResponseDTO start(StartGameDTO startedGameDTO);
}


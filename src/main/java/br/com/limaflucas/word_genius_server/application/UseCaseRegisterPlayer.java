package br.com.limaflucas.word_genius_server.application;

import br.com.limaflucas.word_genius_server.application.dtos.PlayerDTO;
import br.com.limaflucas.word_genius_server.application.dtos.RegisteredPlayerDTO;

public interface UseCaseRegisterPlayer {

    RegisteredPlayerDTO register(PlayerDTO playerDTO);
}

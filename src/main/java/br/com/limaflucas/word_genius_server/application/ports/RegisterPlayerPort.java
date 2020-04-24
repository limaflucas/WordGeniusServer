package br.com.limaflucas.word_genius_server.application.ports;

import br.com.limaflucas.word_genius_server.application.dtos.PlayerPortDTO;

public interface RegisterPlayerPort {

    PlayerPortDTO register(PlayerPortDTO playerPortDTO);
}

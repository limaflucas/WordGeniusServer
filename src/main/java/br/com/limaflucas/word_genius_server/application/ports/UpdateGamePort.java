package br.com.limaflucas.word_genius_server.application.ports;

import br.com.limaflucas.word_genius_server.application.dtos.UpdatedGameDTO;

public interface UpdateGamePort {

    UpdatedGameDTO update (UpdatedGameDTO updatedGameDTO);
}

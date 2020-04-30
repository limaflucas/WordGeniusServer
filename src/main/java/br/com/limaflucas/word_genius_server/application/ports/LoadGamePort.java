package br.com.limaflucas.word_genius_server.application.ports;

import br.com.limaflucas.word_genius_server.application.dtos.StartedGameDTO;

import java.util.UUID;

public interface LoadGamePort {

//    FIXME :: SUBSTITUIR POR DTO PROPRIO POIS PODE SER IMPACTADO CASO O PROCESSO DE INICILIZACAO DO JOGO MUDE
    StartedGameDTO load(UUID gameID);
}

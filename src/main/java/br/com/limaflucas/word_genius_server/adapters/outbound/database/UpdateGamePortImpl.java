package br.com.limaflucas.word_genius_server.adapters.outbound.database;

import br.com.limaflucas.word_genius_server.adapters.outbound.database.repositories.GameRepository;
import br.com.limaflucas.word_genius_server.application.dtos.UpdatedGameDTO;
import br.com.limaflucas.word_genius_server.application.ports.UpdateGamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class UpdateGamePortImpl implements UpdateGamePort {

    private final GameRepository gameRepository;

    @Override
    @Transactional
    public UpdatedGameDTO update(UpdatedGameDTO updatedGameDTO) {
        if (this.gameRepository.upateRunningGame(updatedGameDTO.getGameID(), updatedGameDTO.getSequence(), updatedGameDTO.getLastSequenceGeneratedAt()) == 1)
            return updatedGameDTO;
        else
//            TODO :: INCLUIR TRATAMENTO PARA FALHA DE ATUALIZACAO
            return null;
    }
}

package br.com.limaflucas.word_genius_server.adapters.outbound.database;

import br.com.limaflucas.word_genius_server.adapters.outbound.database.entities.Games;
import br.com.limaflucas.word_genius_server.application.dtos.StartedGameDTO;
import br.com.limaflucas.word_genius_server.application.ports.StartGamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartGamePortImpl implements StartGamePort {

    private final GameRepository gameRepository;

    @Override
    public StartedGameDTO start(StartedGameDTO startedGameDTO) {

        this.gameRepository.save(new Games(startedGameDTO.getGameID(), startedGameDTO.getPlayerID(), startedGameDTO.getStartedAt(), startedGameDTO.getSequence(), startedGameDTO.getLastGeneratedSequenceAt()));
        return startedGameDTO;
    }
}
